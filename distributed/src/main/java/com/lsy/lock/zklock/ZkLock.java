package com.lsy.lock.zklock;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 利用ZK临时顺序子节点的唯一性，实现分布式锁。
 *
 * @author YY
 */
public class ZkLock implements Lock {
    /**
     * 使用本地线程 保证线程安全。
     */
    private ThreadLocal<ZooKeeper> zk = new ThreadLocal<ZooKeeper>();
    private String LOCK_NAME = "/zkLock";
    private ThreadLocal<String> CURRENT_NODE = new ThreadLocal<String>();

    /**
     * 获取锁
     */
    @Override
    public void lock() {
        this.initZk();
        // 尝试加锁
        if (tryLock()) {
            // 阻塞
            System.out.println(Thread.currentThread().getName()  + " 拿到锁了");
        }
        // 进入等待 监听

        // 再次尝试
    }

    private void initZk() {
        if (zk.get() == null) {
            try {
                zk.set(new ZooKeeper("120.79.134.119:2181"
                        , 3000
                        , new Watcher() {
                    @Override
                    public void process(WatchedEvent watchedEvent) {
                        // watcher
                        System.out.println("---- 连接成功 ----");
                    }
                }));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 仅在调用时锁为空闲状态才获取该锁。
     *
     * @return
     */
    @Override
    public boolean tryLock() {

        final String nodeName = LOCK_NAME + "/zk_";

        try {
            // 创建前 进行判定父节点是否存在
            // 创建临时顺序节点  /zkLock/zk_00000001
            CURRENT_NODE.set(zk.get().create(nodeName // 节点名
                    , new byte[0] // 节点内容
                    , ZooDefs.Ids.OPEN_ACL_UNSAFE // ACL
                    , CreateMode.EPHEMERAL_SEQUENTIAL)); // 临时顺序节点

            // 查父节点的所有子节点 : zk_00000001, zk_00000002, zk_00000003
            List<String> list = zk.get().getChildren(LOCK_NAME, false);
            // 排序
            Collections.sort(list);
            // 获取最小值 定义最小值获取锁
            String minNode = list.get(0);

            if ((LOCK_NAME + "/" + minNode).equals(CURRENT_NODE.get())) {
                // 拿到锁
                // 判断最小子节点 是否 等于当前创建的节点
                return true;
            } else {
                // 等待锁
                // 现在的节点名称
                String currentNodeSimpleName = CURRENT_NODE.get().substring(CURRENT_NODE.get().lastIndexOf("/") + 1);
                // 当前节点的下标
                Integer currentIndex = list.indexOf(currentNodeSimpleName);
                // 当前节点的前一个节点
                String prevNodeName = list.get(currentIndex - 1);

                final CountDownLatch countDownLatch = new CountDownLatch(1);

                // 绑定监听器 并 阻塞
                zk.get().exists(LOCK_NAME + "/" + prevNodeName, new Watcher() {
                    @Override
                    public void process(WatchedEvent watchedEvent) {
                        // 监听节点删除事件
                        if (Event.EventType.NodeDeleted.equals(watchedEvent.getType())) {
                            // 开始阻塞
                            countDownLatch.countDown();
                            System.out.println(Thread.currentThread().getName() + " 唤醒锁了");
                        }
                    }
                });
                //..

                System.out.println(Thread.currentThread().getName() + " 等待锁");
                // 结束阻塞
                countDownLatch.await();
                // 再次尝试
                //lock();
                // 获取锁
                return true;
            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 如果锁在给定的等待时间内空闲，并且当前线程未被中断，则获取锁。
     *
     * @param time 时间
     * @param unit 时间长度
     * @return
     * @throws InterruptedException
     */
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }


    /**
     * 如果当前线程未被中断，则获取锁。
     *
     * @throws InterruptedException
     */
    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    /**
     * 释放锁。
     */
    @Override
    public void unlock() {

        try {
            // 删除ZK子节点 -1强制忽略版本号
            zk.get().delete(CURRENT_NODE.get(), -1);
            // 关闭线程
            CURRENT_NODE.remove();
            // 关闭ZK接
            zk.get().close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }

    }

    /**
     * 返回绑定到此 Lock 实例的新 Condition 实例。
     *
     * @return
     */
    @Override
    public Condition newCondition() {
        return null;
    }
}
