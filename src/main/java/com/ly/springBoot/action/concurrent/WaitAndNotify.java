package com.ly.springBoot.action.concurrent;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2020/6/26 0026 18:05
 */
public class WaitAndNotify {
    private static Object a = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("threadA try get resource a");
                    synchronized (a) {
                        System.out.println("threadA  get resource a");
                        System.out.println("threadA begin wait a");
                        a.wait(10000);
                        System.out.println("threadA end wait a");
                    }
                    System.out.println("傻逼A");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("threadB try get resource a");
                    synchronized (a) {
                        System.out.println("threadB  get resource a");
                        System.out.println("threadB begin wait a");
                        a.wait();
                        System.out.println("threadB end wait a");
                    }
                    System.out.println("傻逼B");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("唤醒线程");
                a.notifyAll();
//                    a.notify();//随机唤醒之前在该共享变量上调用wait()挂起的其中一个线程
//                    try {
//                        a.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }

            }
        });

        threadA.start();
//        threadB.start();
//        Thread.sleep(1000);
//        threadC.start();
        threadA.join();//join:当该线程执行完后,才会继续往下面执行
//        threadB.join();
        System.out.println("全是sb");
    }
}
