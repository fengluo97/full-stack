package com.fengluo.learn.java.designpattern.observe;

/**
 * @Author: fengluo
 * @Date: 2023/11/21 20:48
 */
public class ObserveClient {

    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer observerA = new ConcreteObserverA(subject);
        Observer observerB = new ConcreteObserverB(subject);
        subject.setState(0);
        subject.setState(1);
    }

}
