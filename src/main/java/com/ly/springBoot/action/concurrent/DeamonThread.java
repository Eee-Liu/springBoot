package com.ly.springBoot.action.concurrent;

/**
 * @Author: LiuYi
 * @Description: 守护线程,用户线程.两者区别之一就是用户线程的结束会影响jvm是否正常退出.当最后一个非守护线程结束后,JVM便退出而且不管是否还有守护线程未结束.
 * @Date: Created in 2020/6/27 0027 22:42
 */
public class DeamonThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {

                }
            }
        });
        //设置为守护线程
//        thread.setDaemon(true);
        thread.start();
        System.out.println("main thread over");
    }

}
