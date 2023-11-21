package com.fengluo.learn.java.designpattern.observe;

/**
 * @Author: fengluo
 * @Date: 2023/11/21 20:16
 */
public class ConcreteObserverA extends Observer {

    public ConcreteObserverA(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        if (subject.getState() == 0) {
            System.out.println(this.getClass().getName() + " " + subject.getState());
        }
    }

}
