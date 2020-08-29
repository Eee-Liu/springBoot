package com.ly.springBoot.action.concurrent.线程同步器;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: LiuYi
 * @Description: CountDownLatch线程同步测试.
 * 初始化设定好"锁"的数量,每次countdown()"锁"数量-1;调用await()的线程,若"锁"(aqs中的state值)大于0便阻塞,在"锁"为0的时候被唤醒继续执行.CountDownLatch的"锁"数量是一次性的,到0就结束了不能重复使用.跟join()功能类似,当更灵活.
 * @Date: Created in 2020/8/29 0029 10:14
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                countDownLatch.countDown();
                System.out.println(Thread.currentThread()+"-1 countDown over");
            }
        });

        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                countDownLatch.countDown();
                System.out.println(Thread.currentThread()+"-2 countDown over");
            }
        });

        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                countDownLatch.countDown();
                System.out.println(Thread.currentThread()+"-2 countDown over");
            }
        });

        countDownLatch.await();
        System.out.println("main over");
        countDownLatch.await();
        System.out.println("main over2");
    }
}
