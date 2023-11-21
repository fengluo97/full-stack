package com.fengluo.learn.java.designpattern.observe;

/**
 * @Author: fengluo
 * @Date: 2023/11/21 20:15
 */
public abstract class Observer {

    protected Subject subject;

    public abstract void update();

}
