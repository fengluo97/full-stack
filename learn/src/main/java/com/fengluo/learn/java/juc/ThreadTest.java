package com.fengluo.learn.java.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: fengluo
 * @Date: 2023/10/29 16:43
 */
@Slf4j
public class ThreadTest {

    public static void main(String[] args) {
        //for (int i = 0; i < 3; i++) {
        //    Job job = new Job(String.valueOf(i));
        //    job.start();
        //}
        //for (int i = 0; i < 3; i++) {
        //    Thread job = new Thread(new JobRunnable(String.valueOf(i)));
        //    job.start();
        //}
        for (int i = 0; i < 3; i++) {
            FutureTask<Integer> futureTask = new FutureTask<>(new JobCallable(String.valueOf(i)));

            Thread job = new Thread(futureTask);

            job.start();
            try {
                System.out.println(futureTask.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("主线程执行完毕");
    }

}

@Slf4j
class Job extends Thread {

    private final String name;

    Job(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                log.info("Thread {} execute...", name);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

@Slf4j
class JobRunnable implements Runnable {

    private final String name;

    JobRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                log.info("Thread {} execute...", name);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

@Slf4j
class JobCallable implements Callable<Integer> {

    private final String name;

    JobCallable(String name) {
        this.name = name;
    }

    @Override
    public Integer call() {
        for (int i = 0; i < 3; i++) {
            try {
                log.info("Thread {} execute...", name);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return 1;
    }
}