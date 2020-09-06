package com.lsy.lock.zklock2;

/**
 * @Description: zkTest
 * @Author: 敖丙
 * @date: 2020-04-06
 **/
public class ZkLock {
    static int inventory = 10;
    private static final int NUM = 5;

    private static Zk zk = new Zk();

    public static void main(String[] args) {
        try {
            for (int i = 0; i < NUM; i++) {
                new Thread(() -> {
                    try {
                        zk.lock();
                        Thread.sleep(1000);
                        if (inventory > 0) {
                            inventory--;
                        }
                        System.out.println(inventory);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        zk.unlock();
                        System.out.println("释放锁");
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}