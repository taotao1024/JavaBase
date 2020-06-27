package com.lsy.thread.concurrentutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * java.util.concurrent.CountDownLatch
 * <p>
 * 类似于join
 * <p>
 * sleep是等待时间，以时间为单位。
 * <p>
 * CountDownLatch是等待几个任务，以任务为单位。
 * <p>
 * FightQueryDemo
 * <p/>
 * CountDownLatch是通过一个计数器实现的，计数器的初始值为线程数量。每当
 * 一个线程完成自己的任务后，计数器的值-1，当计数器值达到0时，它表示所有
 * 线程已完成任务，然后在锁上等待的线程就可以恢复了。
 *
 * CountDownLatch(int count)中，count就是闭锁需要等待的线程数量。这个值只能设置一次。
 * 而且CountDownLatch没有提供任何机制去修改这个值。与CountDownLatch的第一次交互是主线程
 * 等待其他线程，主线程必须在启动其他线程后立即调用CountDownLatch().await()方法。
 * 这样主线程就会阻塞在这个方法上，直到其他线程完成各自的任务。其他线程完成各自任务后，通过
 * 调用CountDownLatch().countDown()方法完成通知，每调用一次countDown()方法，count就减一。
 * 当count的值为0时，主线程就能通过await()方法，恢复自己的任务。
 *
 * @author YY
 */
public class CountDownLatchDemo {

    private static List<String> companyList = Arrays.asList("东方航空", "南方航空", "海南航空");
    private static List<String> fightList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        //起点
        String origin = " 北京 ";
        //终点
        String dest = " 上海 ";
        Thread[] threads = new Thread[companyList.size()];
        //并发工具
        CountDownLatch latch = new CountDownLatch(companyList.size());
        int threadsMax = threads.length;
        for (int i = 0; i < threadsMax; i++) {
            String name = companyList.get(i);
            threads[i] = new Thread(() -> {
                    System.out.printf("%s 查询从%s到%s的机票\n", name, origin, dest);
                    //随机产生票数
                    int val = new Random().nextInt(10);
                    try {
                        TimeUnit.SECONDS.sleep(val);
                        fightList.add(name + " : " + val);
                        System.out.printf("%s公司查询成功！\n", name);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        latch.countDown();
                    }
            });
            threads[i].start();
        }
        latch.await();
        System.out.println("==============查询结果如下：================");
        fightList.forEach(System.out::println);
    }
}
