package com.fengluo.learn.java.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: fengluo
 * @Date: 2023/11/12 18:41
 */
public class JvmMain {

    public static void main(String[] args) {
        int[] arr = new int[1];

        System.out.println(test1());
    }

    private static List<String> test() {
        List<String> list = new ArrayList<>();
        try {
            list.add("X");
            // return 之前会将返回值临时复制一份到局部变量中，然后去执行 finally，如果 finally 中没有 return，则读取副本返回
            return list;
        } catch (Exception e) {
            list.add("Y");
            return list;
        } finally {
            list.add("Z");
        }
    }

    private static int test1() {
        int x;
        try {
            x = 1;
            // return 之前会将返回值临时复制一份到局部变量中，然后去执行 finally，如果 finally 中没有 return，则读取副本返回
            // throw new RuntimeException();
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
        // 没抛异常 打印 1，抛异常 打印 2
    }

}
