package com.fengluo.learn.java.designpattern.singleton;

/**
 * @Author: fengluo
 * @Date: 2023/11/21 20:55
 */
public class HungarySingleton {

    private static HungarySingleton instance = new HungarySingleton();

    private HungarySingleton() {}

    public static HungarySingleton getInstance() {
        return instance;
    }

}
