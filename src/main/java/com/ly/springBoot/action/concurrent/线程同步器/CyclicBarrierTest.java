package com.ly.springBoot.action.concurrent.线程同步器;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: LiuYi
 * @Description: 环形屏障同步器测试.
 * 初始化一个CyclicBarrier,参数一:屏障上的锁数量,参数一:突破屏障后执行的任务;
 * 当调用await()后屏障上的锁数量-1,若锁数量>0线程阻塞;
 * 若=0突破屏障执行参数二指定的任务并唤醒线程,还会重置锁的数量因此CyclicBarrier是一个可重复使用的同步器
 * (ps:CyclicBarrier内部有两个参数'parties'记录初始化执行的线程数,'count'当前锁数量.当突破屏障后通过count=parties进行赋值重置锁数量,达到可重复使用)
 *
 * 这同步器有点像赛马道的栅栏,当每个赛道的马儿都到了栅栏,这时候把栅栏打开(突破屏障)马儿一起进行下一阶段的比赛.相当于可重复使用的CountDownLatch
 * 适合多线程执行后续任务有执行前置条件的场景下.例如拼团,需要3个人参与下单才能拼团成功,当只有2个人的时候这2个人不能进行拼团后续操作,只能等第三个人参与突破屏障后才能一起走后续流程
 * @Date: Created in 2020/8/29 0029 10:29
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("cyclicBarrier 钩子任务ly");
            }
        });
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + "task-1 over");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread() + "task-2 over");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread() + "task-3 over");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + "task-1 over");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread() + "task-2 over");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread() + "task-3 over");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread() + "task-1 over");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread() + "task-2 over");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread() + "task-3 over");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        //记得关闭线程池!!!
        threadPool.shutdown();
    }
}
