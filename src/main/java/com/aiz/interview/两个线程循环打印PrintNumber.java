package com.aiz.interview;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZhangYao
 * @className 两个线程循环打印PrintNumber
 * @description 两个线程循环打印
 * @date Create in 11:45 2023/8/21
 */
public class 两个线程循环打印PrintNumber {

    /**
     * new Thread
     * 两个线程交替打印0-100
     */
    @Test
    public void printNumber() {
        Thread t1 = new Thread(() -> {
            // 编写"线程1"打印逻辑
            while (num < COUNT) {
                synchronized (lock) {
                    while (num % 2 != 0) {
                        try {
                            //让出锁
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 执行自己的逻辑
                    System.out.println(Thread.currentThread().getName() + ":" + num++);
                    lock.notifyAll();
                }
            }
        }, "t1");
        t1.start();

        Thread t2 = new Thread(() -> {
            // 编写"线程2"打印逻辑
            while (num < COUNT) {
                synchronized (lock) {
                    while (num % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 执行自己的逻辑
                    System.out.println(Thread.currentThread().getName() + ":" + num++);
                    lock.notifyAll();
                }
            }
        }, "t2");
        t2.start();
    }


    static volatile int num = 0;
    static Object lock = new Object();
    static final int COUNT = 100;

    /**
     * 使用线程池
     * 两个线程交替打印0-100
     */
    @Test
    public void printNumber2() {
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.execute(task1);
        threadPool.execute(task2);
    }

    class Task1 implements Runnable {
        @Override
        public void run() {
            // "线程1"打印逻辑
            while (num < COUNT) {
                synchronized (lock) {
                    // 获取到锁
                    while (num % 2 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 执行自己的逻辑
                    System.out.println(Thread.currentThread().getName() + ":" + num++);
                    lock.notifyAll();
                }
            }
        }
    }

    class Task2 implements Runnable {
        @Override
        public void run() {
            // "线程2"打印逻辑
            while (num < COUNT) {
                synchronized (lock) {
                    // 获取到锁
                    while (num % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 执行自己的逻辑
                    System.out.println(Thread.currentThread().getName() + ":" + num++);
                    lock.notifyAll();
                }
            }
        }
    }
}
