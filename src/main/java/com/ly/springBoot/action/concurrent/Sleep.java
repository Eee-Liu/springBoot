package com.ly.springBoot.action.concurrent;

/**
 * @Author: LiuYi
 * @Description: 让线程睡眠一段时间,待时间到了进入就绪状态.睡眠期间不会释放持有的锁资源,也不会进行cpu竞争.
 *
 * 如果在睡眠期间其他线程调用了该线程的interrupt（）方法中断了该线程，则该线程会在调用sleep方法的地方抛出InterruptedException异常而返回。
 * @Date: Created in 2020/6/26 0026 23:07
 */
public class Sleep {
    public static Object a =new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a) {
                    System.out.println("threadA begin sleep");
                    try {
                        Thread.sleep(5000);
                    System.out.println("threadA end sleep");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a) {
                    System.out.println("threadB begin sleep");
                    try {
                        Thread.sleep(5000);
                    System.out.println("threadB end sleep");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        threadA.start();
        threadB.start();
        //如果在睡眠期间其他线程调用了该线程的interrupt（）方法中断了该线程，则该线程会在调用sleep方法的地方抛出InterruptedException异常而返回。
        threadA.interrupt();
    }
}
