package com.fengluo.learn.java.juc;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: fengluo
 * @Date: 2023/11/1 12:37
 */
@Slf4j
public class WaitNotify {

    static boolean flag = true;

    static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread wait = new Thread(new Wait());
        wait.start();

        Thread.sleep(1000);

        Thread notify = new Thread(new Notify());
        notify.start();

    }

    static class Wait implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(flag);
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("end");
            }
        }
    }

    static class Notify implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("notify 拿到锁，唤醒wait线程");
                lock.notify();
                flag = false;
            }
        }
    }

}
