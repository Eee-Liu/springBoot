package com.ly.springBoot.action.concurrent.线程同步器;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author: LiuYi
 * @Description: 信号同步器测试
 * semaphore初始化一个持有信号量并不指定线程数量,每次调用release()增加持有信号量(ps:默认是1,也可以指定增量).
 * 在需要的地方调用acquire()请求信号量,若持有信号量>期望值线程阻塞;若持有信号量=期望值线程被唤醒.
 * 在一定程度上semaphore可以通过指定合适的请求信号量来实现CyclicBarrier的功能.
 * @Date: Created in 2020/8/29 0029 11:00
 */
public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {
        //指定初始信号量
        Semaphore semaphore = new Semaphore(0);
        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        threadPool.submit(new Runnable() {
            @Override
            public void run() {
                semaphore.release(3);
                //释放信号,不传参就默认信号量+1
//                semaphore.release();
                System.out.println(Thread.currentThread() + "释放信号啦");
            }
        });
        //请求信号量,若持有信号量>期望值线程阻塞;若持有信号量=期望值线程被唤醒
        semaphore.acquire(3);
        System.out.println(Thread.currentThread() + "main 收到信号");

        //记得关闭线程池!!!
        threadPool.shutdown();
    }
}
