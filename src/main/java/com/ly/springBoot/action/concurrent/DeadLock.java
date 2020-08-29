package com.ly.springBoot.action.concurrent;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2020/6/27 0027 21:59
 */
public class DeadLock {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a) {
                    System.out.println("获取到资源a");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("尝试获取资源b");
                    synchronized (b) {
                        System.out.println("获取到资源b");
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b) {
                    System.out.println("获取到资源b");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("尝试获取资源a");
                    synchronized (a) {
                        System.out.println("获取到资源a");
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
