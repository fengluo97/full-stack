package com.fengluo.learn.java.juc;

/**
 * @Author: fengluo
 * @Date: 2023/10/29 16:43
 */

public class ThreadTest {

    public static void main(String[] args) {
        ThreadJob threadJob = new ThreadJob();
        threadJob.start();
    }

}

class ThreadJob extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(100);
                System.out.println("执行中。。。");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
