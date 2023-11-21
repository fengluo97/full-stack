package com.fengluo.learn.java.designpattern.singleton;

import java.time.Duration;

/**
 * @Author: fengluo
 * @Date: 2023/11/21 20:59
 */
public class DoubleCheckSingleton {

    private volatile static DoubleCheckSingleton instance = new DoubleCheckSingleton();

    private DoubleCheckSingleton() {}

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

}
