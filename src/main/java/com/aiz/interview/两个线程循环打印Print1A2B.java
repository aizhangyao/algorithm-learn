package com.aiz.interview;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ZhangYao
 * @className 两个线程循环打印Print1A2B
 * @description 两个线程循环打印数字和字母
 * @date Create in 14:21 2023/8/21
 */
public class 两个线程循环打印Print1A2B {

    /**
     * synchronized wait notify
     */
    @Test
    public void print1A2B_Synchronized() {
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.execute(task1);
        threadPool.execute(task2);
    }

    static final Object lock = new Object();
    static final int NUM = 26;

    /**
     * 打印数字
     */
    class Task1 implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < NUM; i++) {
                    System.out.print(i + 1);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify();
                }
            }
        }
    }

    /**
     * 打印字母
     */
    class Task2 implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < NUM; i++) {
                    System.out.print((char) ('A' + i));
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify();
                }

            }
        }
    }

    static Thread t1, t2;

    /**
     * LockSupport
     */
    @Test
    public void print1A2B_LockSupport() {
        t1 = new Thread(() -> {
            for (int i = 0; i < NUM; i++) {
                System.out.print(i);
                // 叫醒T2
                LockSupport.unpark(t2);
                // T1阻塞
                LockSupport.park();
            }
        });

        t2 = new Thread(() -> {
            for (int i = 0; i < NUM; i++) {
                // T2阻塞
                LockSupport.park();
                System.out.print((char) ('A' + i));
                // 叫醒T1
                LockSupport.unpark(t1);
            }
        });
        t1.start();
        t2.start();
    }

    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition c1 = reentrantLock.newCondition();
    private Condition c2 = reentrantLock.newCondition();
    @Test
    public void print1A2B_ReentrantLock() {

    }
}
