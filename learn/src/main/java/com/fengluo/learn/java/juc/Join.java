package com.fengluo.learn.java.juc;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: fengluo
 * @Date: 2023/11/1 13:14
 */
@Slf4j
public class Join {

    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Demo(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
        Thread.sleep(1000);
        System.out.println("main 线程 执行完毕");
    }

    static class Demo implements Runnable {
        private Thread previous;
        Demo(Thread previous) {
            this.previous = previous;
        }
        @Override
        public void run() {
            try {
                previous.join();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " 执行完毕");
        }
    }

}
