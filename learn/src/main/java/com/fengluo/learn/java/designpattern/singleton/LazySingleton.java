package com.fengluo.learn.java.designpattern.singleton;

/**
 * @Author: fengluo
 * @Date: 2023/11/21 20:54
 */
public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {}

    public synchronized static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}
