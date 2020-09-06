package com.lsy.config.zkconfig;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author YY
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Config config = new Config("120.79.134.119:2181");

        config.save("timeout", "1");
        for (int i = 0; i < 100; i++) {
            System.out.println("=====" + config.get("timeout"));
            System.out.println("=====" + config.get("grade"));
            TimeUnit.SECONDS.sleep(5);
        }
    }
}
