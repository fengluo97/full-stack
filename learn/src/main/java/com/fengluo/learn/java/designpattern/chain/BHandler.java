package com.fengluo.learn.java.designpattern.chain;

/**
 * @Author: fengluo
 * @Date: 2023/11/20 20:32
 */
public class BHandler extends AbstractHandler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("B")) {
            System.out.println(request + "请求被处理" + this.getClass().getName());
        } else {
            AbstractHandler next = getNext();
            if (next != null) {
                next.handleRequest(request);
            } else {
                System.out.println("该请求没有被处理");
            }
        }
    }
}
