package com.lsy.thread.distributed_lock;

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

    private ThreadLocal<ZooKeeper> zk = new ThreadLocal<ZooKeeper>();
    private final String LOCK_NAME = "/zkLock";
    private ThreadLocal<String> CURRENT_NODE = new ThreadLocal<String>();

    @Override
    public void lock() {
        init();
        if (tryLock()) {
            // 阻塞
            System.out.println("拿到锁了");
        }
    }

    private void init() {
        if (zk.get() == null) {
            try {
                zk.set(new ZooKeeper("120.79.134.119:2181", 3000, new Watcher() {
                    @Override
                    public void process(WatchedEvent watchedEvent) {
                        // watcher
                        System.out.println("连接成功");
                    }
                }));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean tryLock() {

        final String nodeName = LOCK_NAME + "/zk_";

        try {
            // 创建临时顺序节点  /zkLock/zk_00000001
            CURRENT_NODE.set(zk.get().create(nodeName
                    , new byte[0]
                    , ZooDefs.Ids.OPEN_ACL_UNSAFE
                    , CreateMode.EPHEMERAL_SEQUENTIAL));

            // 查子节点 : zk_00000001, zk_00000002, zk_00000003
            List<String> list = zk.get().getChildren(LOCK_NAME, false);
            // 排序
            Collections.sort(list);
            System.out.println(list);

            // 获取最小值 定义最小值获取锁
            String minNode = list.get(0);

            if ((LOCK_NAME + "/" + minNode).equals(CURRENT_NODE.get())) {
                // 拿到锁
                return true;
            } else {
                // 等待锁
                // watcher
                Integer currentIndex = list.indexOf(CURRENT_NODE.get().substring(CURRENT_NODE.get().lastIndexOf("/") + 1));
                String prevNodeName = list.get(currentIndex - 1);

                final CountDownLatch countDownLatch = new CountDownLatch(1);

                zk.get().exists(LOCK_NAME + "/" + prevNodeName, new Watcher() {
                    @Override
                    public void process(WatchedEvent watchedEvent) {
                        if (Event.EventType.NodeDeleted.equals(watchedEvent.getType())) {
                            countDownLatch.countDown();
                            System.out.println(Thread.currentThread().getName() + "唤醒锁了");
                        }
                    }
                });
                //..

                System.out.println(Thread.currentThread().getName() + "等待锁");
                countDownLatch.await();
            }

        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void unlock() {

        try {
            // 删除ZK子节点
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


    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
