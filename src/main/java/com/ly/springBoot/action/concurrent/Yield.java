package com.ly.springBoot.action.concurrent;

/**
 * @Author: LiuYi
 * @Description: 当前线程让出cpu执行资源,然后处于就绪状态.线程调度器开始下一轮的线程调度,当然也有可能会再调度到刚刚让出cpu的那个线程.
 * @Date: Created in 2020/6/26 0026 23:23
 */
public class Yield {
    public static class RunnableTask implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<5;i++){
                if (i==0){
                    System.out.println(Thread.currentThread().getName()+"yield cpu");
                  Thread.yield();
                }
            }
            System.out.println(Thread.currentThread().getName()+"憨批");
        }
    }

    public static void main(String[] args) {
        RunnableTask runnableTask = new RunnableTask();
        new Thread(runnableTask).start();
        new Thread(runnableTask).start();
        new Thread(runnableTask).start();
    }
}
