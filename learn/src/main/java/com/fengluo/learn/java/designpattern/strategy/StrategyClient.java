package com.fengluo.learn.java.designpattern.strategy;

/**
 * @Author: fengluo
 * @Date: 2023/11/20 23:31
 */
public class StrategyClient {

    private static AbstractStrategy minusStrategy = new MinusStrategy();

    private static AbstractStrategy sumStrategy = new SumStrategy();

    public static void main(String[] args) {
        System.out.println(doOperation(minusStrategy, 1, 1));
        System.out.println(doOperation(sumStrategy, 1, 1));
    }

    public static int doOperation(AbstractStrategy strategy, int num1, int nums2) {
        return strategy.operation(num1, nums2);
    }

}
