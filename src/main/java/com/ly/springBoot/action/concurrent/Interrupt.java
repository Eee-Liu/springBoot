package com.ly.springBoot.action.concurrent;

/**
 * @Author: LiuYi
 * @Description: Java中的线程中断是通过设置线程的中断标志并不能直接终止该线程的执行,而是被中断的线程根据中断状态自行处理.
 * 当A线程调用了wait,join,sleep系列方法阻塞线程后,B线程调用A线程的interrupt方法,线程A会在调用这些方法的地方抛出InterruptedException异常而返回,并且清除中断标记恢复为false
 * @Date: Created in 2020/6/26 0026 23:41
 */
public class Interrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    //设置线程的中断标志并不能直接终止该线程的执行,而是被中断的线程根据中断状态自行处理
                    try {

//                        Thread.sleep(10000);
                        synchronized (this){
                            this.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        //从执行结果来看，如果在sleep状态下停止某一线程，会进入catch语句，并且清除停止状态值，使之变为false。
                        System.out.println("老子挂了,"+Thread.currentThread().getState()+","+Thread.currentThread().isInterrupted());
                        break;
                    }
                    System.out.println(Thread.currentThread()+"老子还在执行!"+Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println("interrupt thread begin "+thread.isInterrupted());
        thread.interrupt();
        System.out.println("interrupt thread end "+thread.isInterrupted());
        System.out.println(Thread.currentThread()+"main thread over");
    }
}
