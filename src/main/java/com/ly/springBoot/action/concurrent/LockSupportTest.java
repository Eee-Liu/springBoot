package com.ly.springBoot.action.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author: LiuYi
 * @Description:    park(),线程默认不持有与LockSupport的许可书当调用park()时会阻塞线程.在调用unpark()方法后会返回线程,调用interrupt()标记线程中断标识后也会返回.
 *  unpark(Thread)方法会使参数线程持有许可证,若线程被阻塞了还会使其立即返回
 * @Date: Created in 2020/7/12 0012 15:53
 */
public class LockSupportTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("begin park");
//                LockSupport.unpark(Thread.currentThread());
//                while (!Thread.currentThread().isInterrupted()){
                LockSupport.park();
                LockSupport.park(this);
                  LockSupport.parkNanos(1000);
//                }
                System.out.println("end park");
            }
        });
        thread.start();
        Thread.sleep(2000);
//        thread.interrupt();
//        LockSupport.unpark(thread);
        thread.join();
        System.out.println("main thread sout");
    }
}
