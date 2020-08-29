package com.ly.springBoot.action.concurrent;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2020/7/5 0005 16:08
 */
public class AtomicLongTest {
    static AtomicInteger count = new AtomicInteger();
    static Integer[] array1 = {0, 1, 2, 0, 0, 0, 5, 0,0, 1, 2, 0, 0, 0, 5, 0,0, 1, 2, 0, 0, 0, 5, 0,0, 1, 2, 0, 0, 0, 5, 0,0, 1, 2, 0, 0, 0, 5, 0,0, 1, 2, 0, 0, 0, 5, 0,0, 1, 2, 0, 0, 0, 5, 0,0, 1, 2, 0, 0, 0, 5, 0,0, 1, 2, 0, 0, 0, 5, 0,0, 1, 2, 0, 0, 0, 5, 0};
    static Integer[] array2 = {0, 1, 2, 0, 0, 0, 5, 0,0, 1, 2, 0, 0, 0, 5, 0,0, 1, 2, 0, 0, 0, 5, 0,0, 1, 2, 0, 0, 0, 5, 0,0, 1, 2, 0, 0, 0, 5, 0,0, 1, 2, 0, 0, 0, 5, 0,0, 1, 2, 0, 0, 0, 5, 0,0, 1, 2, 0, 0, 0, 5, 0,0, 1, 2, 0, 0, 0, 5, 0,0, 1, 2, 0, 0, 0, 5, 0};

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < array2.length; i++) {
                    if (0 == array2[i]) {
                        count.incrementAndGet();
                    }
                }
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("一共几个0->" + count);
    }
}
