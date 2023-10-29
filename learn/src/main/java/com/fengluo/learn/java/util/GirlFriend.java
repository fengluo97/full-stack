package com.fengluo.learn.java.util;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: fengluo
 * @Date: 2023/10/30 0:02
 */
@Slf4j
public class GirlFriend {

    // 每月惊喜次数
    private static final int TIMES_PER_MONTH = 3;

    // 惊喜时间间隔天数
    private static final int TIMES_INTERVAL = 7;

    public static void main(String[] args) {
        System.out.println("===================================");
        String myWord = "爱意东升西落 浪漫至死不渝 这个月也是好男人";
        for (int i = 0; i < myWord.length(); i++) {
            try {
                System.out.print(myWord.charAt(i));
                Thread.sleep(new Random().nextInt(50) + 50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
        System.out.println("===================================");

        List<String> things = new ArrayList<>();
        // 增加随机权重
        things.add("买奶茶");things.add("买奶茶");things.add("买奶茶");
        things.add("买零食");things.add("买零食");things.add("买零食");
        things.add("买花花");things.add("买花花");things.add("买花花");
        things.add("买衣服（买我想让她穿的嘿嘿）");
        things.add("写情书");
        things.add("买礼物（可以去B站看看有没有什么好玩意儿）");

        List<Integer> whatDayTodo = new ArrayList<>();
        for (int i = 0; i < TIMES_PER_MONTH; i++) {
            int day = new Random().nextInt(30) + 1;
            // 避免随机日期集中，强制打散
            if (whatDayTodo.size() > 0) {
                while (!check(whatDayTodo, day)) {
                    day = new Random().nextInt(30) + 1;
                }
            }
            whatDayTodo.add(day);
        }
        whatDayTodo.sort((o1, o2) -> o1 - o2);
        log.info("===本月惊喜随机完毕===");
        for (int i = 0; i < TIMES_PER_MONTH; i++) {
            log.info("请在{}年{}月{}号 -> {}", LocalDate.now().getYear(), LocalDate.now().getMonthValue(),
                    whatDayTodo.get(i), things.get(new Random().nextInt(things.size())));
        }
    }

    private static boolean check(List<Integer> whatDayTodo, int day) {
        for (int num : whatDayTodo) {
            if (Math.abs(num - day) < TIMES_INTERVAL) {
                return false;
            }
        }
        return true;
    }

}
