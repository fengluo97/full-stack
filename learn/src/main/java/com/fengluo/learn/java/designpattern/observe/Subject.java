package com.fengluo.learn.java.designpattern.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: fengluo
 * @Date: 2023/11/21 0:04
 */
public class Subject {

    private final List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
        this.notifyAllObserver();
    }

    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    public void notifyAllObserver() {
        for (Observer observer : this.observers) {
            observer.update();
        }
    }

}
