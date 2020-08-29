package com.ly.springBoot.action.concurrent;

/**
 * @Author: LiuYi
 * @Description: 当线程调用共享变量的wait()方法时会挂该线程并释放当前共享变量的锁资源.
 * 若该线程持有多个共享变量的锁时,其他的锁资源并不会释放
 * @Date: Created in 2020/6/26 0026 17:32
 */
public class Wait {
    private static Object a = new Object();
    private static Object b = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("threadA try get resource a");
                    synchronized (a) {

                        System.out.println("threadA  get resource a");
                        System.out.println("threadA try get resource b");
                        synchronized (b) {
                            System.out.println("threadA  get resource b");
                            System.out.println("threadA begin wait a");
                            a.wait(1000);
                            b.wait(1000);
                            System.out.println("threadA end wait a");
                        }
                    }
                    System.out.println("傻逼");
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
                        System.out.println("threadB try get resource b");
                        synchronized (b) {
                            System.out.println("threadB  get resource b");
                            System.out.println("threadB begin wait a");
                            a.wait(1000);
                            b.wait(1000);
                            System.out.println("threadB end wait a");
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}
