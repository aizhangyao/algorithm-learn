package com.aiz.leetcode.practice;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName Test
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 23:19 2022/9/13
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        // 示例代码：
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("当前时间: " + new Date() + "n" +
                        "线程名称: " + Thread.currentThread().getName());
            }
        };
        System.out.println("当前时间: " + new Date() + "n" +
                "线程名称: " + Thread.currentThread().getName());
        Timer timer = new Timer("Timer");
        long delay = 10000L;
        timer.schedule(task, delay);
    }
}
