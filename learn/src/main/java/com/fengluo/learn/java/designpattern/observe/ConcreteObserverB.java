package com.fengluo.learn.java.designpattern.observe;

/**
 * @Author: fengluo
 * @Date: 2023/11/21 20:45
 */
public class ConcreteObserverB extends Observer {

    public ConcreteObserverB(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        if (subject.getState() == 1) {
            System.out.println(this.getClass().getName() + " " + subject.getState());
        }
    }
}
