package com.fengluo.learn.java.designpattern.singleton;

/**
 * @Author: fengluo
 * @Date: 2023/11/21 21:02
 */
public class InnerClassSingleton {

    private static class Singleton {
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return Singleton.INSTANCE;
    }
}
