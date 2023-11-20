package com.fengluo.learn.java.designpattern.strategy;

/**
 * @Author: fengluo
 * @Date: 2023/11/20 23:30
 */
public class SumStrategy extends AbstractStrategy {
    @Override
    public int operation(int num1, int num2) {
        return num1 + num2;
    }
}
