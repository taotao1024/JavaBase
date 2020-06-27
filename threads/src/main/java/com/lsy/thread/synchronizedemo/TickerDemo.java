package com.lsy.thread.synchronizedemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * 断续器
 *
 * @author lsy
 */
@RunWith(JUnit4.class)
public class TickerDemo extends Thread {
    private static int index = 1;
    private static final int MAX = 20;

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread().getName() + "号码：" + index++);

        }
    }

    @Test
    public void TestTicker() {
        TickerDemo tickerDemo1 = new TickerDemo();
        TickerDemo tickerDemo2 = new TickerDemo();
        TickerDemo tickerDemo3 = new TickerDemo();
        TickerDemo tickerDemo4 = new TickerDemo();
        tickerDemo1.run();
        tickerDemo2.run();
        tickerDemo3.run();
        tickerDemo4.run();
    }

}
