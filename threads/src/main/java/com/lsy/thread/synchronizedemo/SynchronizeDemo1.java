package com.lsy.thread.synchronizedemo;


import java.util.concurrent.TimeUnit;

/**
 * @author YY
 */
public class SynchronizeDemo1 {

    /**
     * 静态方法锁
     * <p/>
     * flags: ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED
     */
    public synchronized static void accessResources1() {
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + " is running");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 非静态方法锁
     * <p/>
     * flags: ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED
     */
    public synchronized void accessResources2() {
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + " is running");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对象锁、内置锁
     * <p/>
     * monitorenter monitorexit(正常出口) monitorexit(异常出口) JVM指令
     */
    public void accessResources3() {
        // this|Object 指代当前对象 每一个对象都有一个monitor对象（监视器）
        // 类可以有多个对象 每个对象锁之间互相不干扰
        synchronized (this) {
            try {
                //TimeUnit.SECONDS.sleep(2);
                TimeUnit.MINUTES.sleep(2);
                System.out.println(Thread.currentThread().getName() + " is running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 类锁
     * <p/>
     * monitorenter monitorexit(正常出口) monitorexit(异常出口) JVM指令
     */
    public void accessResources4() {
        // ClassLoader  class 对象头  -->  堆  Class（一个锁）  锁所有的对象
        // 所有的对象都共同使用同一个锁
        synchronized (SynchronizeDemo1.class) {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + " is running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        final SynchronizeDemo1 synchronizeDemo = new SynchronizeDemo1();
        for (int i = 0; i < 5; i++) {
            //new Thread(SynchronizeDemo1::accessResources1).start();
            //new Thread(synchronizeDemo::accessResources2).start();
            new Thread(synchronizeDemo::accessResources3).start();
            //new Thread(synchronizeDemo::accessResources4).start();
        }
    }
    // java stack(堆) || java console(控制台) || java p (反编译)
        /*
"Thread-4" #16 prio=5 os_prio=0 tid=0x000000001e0f3000 nid=0x1ac4 waiting on condition [0x000000000ee6f000]
   java.lang.Thread.State: TIMED_WAITING (sleeping)
        at java.lang.Thread.sleep(Native Method)
        at java.lang.Thread.sleep(Thread.java:340)
        at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
        at com.lsy.thread.SynchronizeDemo1.accessResources3(SynchronizeDemo1.java:45)
        - locked <0x0000000780894ea0> (a com.lsy.thread.SynchronizeDemo1)
        at com.lsy.thread.SynchronizeDemo1$$Lambda$1/1747585824.run(Unknown Source)
        at java.lang.Thread.run(Thread.java:748)

"Thread-3" #15 prio=5 os_prio=0 tid=0x000000001e10c000 nid=0x19e8 waiting for monitor entry [0x000000000e59f000]
   java.lang.Thread.State: BLOCKED (on object monitor)
        at com.lsy.thread.SynchronizeDemo1.accessResources3(SynchronizeDemo1.java:45)
        - waiting to lock <0x0000000780894ea0> (a com.lsy.thread.SynchronizeDemo1)
        at com.lsy.thread.SynchronizeDemo1$$Lambda$1/1747585824.run(Unknown Source)
        at java.lang.Thread.run(Thread.java:748)

"Thread-2" #14 prio=5 os_prio=0 tid=0x000000001e10b800 nid=0x1bdc waiting for monitor entry [0x000000000ed5f000]
   java.lang.Thread.State: BLOCKED (on object monitor)
        at com.lsy.thread.SynchronizeDemo1.accessResources3(SynchronizeDemo1.java:45)
        - waiting to lock <0x0000000780894ea0> (a com.lsy.thread.SynchronizeDemo1)
        at com.lsy.thread.SynchronizeDemo1$$Lambda$1/1747585824.run(Unknown Source)
        at java.lang.Thread.run(Thread.java:748)

"Thread-1" #13 prio=5 os_prio=0 tid=0x000000001e108800 nid=0x1fec waiting for monitor entry [0x000000000eb4e000]
   java.lang.Thread.State: BLOCKED (on object monitor)
        at com.lsy.thread.SynchronizeDemo1.accessResources3(SynchronizeDemo1.java:45)
        - waiting to lock <0x0000000780894ea0> (a com.lsy.thread.SynchronizeDemo1)
        at com.lsy.thread.SynchronizeDemo1$$Lambda$1/1747585824.run(Unknown Source)
        at java.lang.Thread.run(Thread.java:748)
     */
}
