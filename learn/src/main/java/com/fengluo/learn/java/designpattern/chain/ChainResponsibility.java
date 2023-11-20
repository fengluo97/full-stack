package com.fengluo.learn.java.designpattern.chain;

/**
 * @Author: fengluo
 * @Date: 2023/11/20 20:23
 */
public class ChainResponsibility {
    public static void main(String[] args) {
        AbstractHandler handlerA = new AHandler();
        AbstractHandler handlerB = new BHandler();
        AbstractHandler handlerC = new CHandler();

        handlerA.setNext(handlerB);
        handlerB.setNext(handlerC);

        handlerA.handleRequest("A");
        handlerA.handleRequest("B");
        handlerA.handleRequest("C");
        handlerA.handleRequest("D");
    }
}
