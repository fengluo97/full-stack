package com.fengluo.learn.java.designpattern.chain;

/**
 * @Author: fengluo
 * @Date: 2023/11/20 20:29
 */
public abstract class AbstractHandler {

    private AbstractHandler next;

    public void setNext(AbstractHandler next) {
        this.next = next;
    }

    public AbstractHandler getNext() {
        return this.next;
    }

    public abstract void handleRequest(String request);

}
