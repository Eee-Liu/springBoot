package com.ly.springBoot.action.concurrent;

/**
 * @Author: LiuYi
 * @Description: Interrupted获取当前线程中断状态,并重置中断标识为false
 * isInterrupt获取该调用线程的中断状态
 * @Date: Created in 2020/6/27 0027 18:26
 */
public class Interrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
//                for (;;){}
            }
        });
        myThread.start();
        Thread.sleep(1000);
        //true true
        myThread.interrupt();
        System.out.println("第一次调用返回值:"+myThread.getState()+","+myThread.isInterrupted());
        System.out.println("第二次调用返回值:"+myThread.getState()+","+myThread.isInterrupted());

        //true false false false
//        System.out.println("第1次调用返回值:"+myThread.isInterrupted());
//        //实际上interrupted的是当前线程即main线程,而非调用线程
//        System.out.println("interrupted第1次调用返回值:"+myThread.interrupted());
//        System.out.println("interrupted第2次调用返回值:"+Thread.currentThread().isInterrupted());
//        System.out.println("interrupted第3次调用返回值:"+Thread.currentThread().isInterrupted());

        //true true false false
//        System.out.println("第1次调用返回值:"+myThread.isInterrupted());
        //实际上interrupted的是当前线程即main线程,而非调用线程
//        System.out.println("interrupted第1次调用返回值:"+myThread.currentThread().interrupted());
//        System.out.println("interrupted第2次调用返回值:"+myThread.isInterrupted());
//        System.out.println("interrupted第3次调用返回值:"+Thread.currentThread().isInterrupted());
    }
}
