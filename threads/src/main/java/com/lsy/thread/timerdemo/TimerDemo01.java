package com.lsy.thread.timerdemo;

import com.lsy.thread.distributedlock.Main;

import javax.lang.model.element.VariableElement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.SimpleFormatter;

/**
 * @author yuanyuan
 * @version 1.0
 * @date 2021/02/01
 */
public class TimerDemo01 {
    private static Timer timer = new Timer();

    public static void main(String[] args) throws ParseException {
        final MyTask myTask = new MyTask();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date parse = sdf.parse("2021-1-1 20:14:30");
        timer.schedule(myTask,parse);
    }

    static class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("定时任务启动，运行时间为:" + new Date());
        }
    }
}
