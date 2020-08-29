package com.ly.springBoot.action.concurrent;

import org.aspectj.weaver.ast.Var;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2020/6/27 0027 23:01
 */
public class ThreadLocalTest {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("thread one");
                System.out.println("treadA:"+threadLocal.get());
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("thread two");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("treadB:"+threadLocal.get());
            }
        });
        threadA.start();
        threadB.start();
    }
}
