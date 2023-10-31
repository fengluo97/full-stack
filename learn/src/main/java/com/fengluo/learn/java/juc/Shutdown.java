package com.fengluo.learn.java.juc;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @Author: fengluo
 * @Date: 2023/11/1 0:06
 */
public class Shutdown {

    public static void main(String[] args) throws InterruptedException {
        Runner one = new Runner();
        Thread currentThread = new Thread(one, "currentThread");
        currentThread.start();
        TimeUnit.SECONDS.sleep(1);
        // 调用该线程的 中断方法，将其中断
        currentThread.interrupt();
        Runner two = new Runner();
        currentThread = new Thread(two, "currentThread");
        currentThread.start();
        TimeUnit.SECONDS.sleep(1);
        // 调用 cancel 改变变量控制
        two.cancel();
    }

    private static class Runner implements Runnable {
        private long i;
        private volatile boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i = " + i);
        }

        private void cancel() {
            on = false;
        }
    }

}
