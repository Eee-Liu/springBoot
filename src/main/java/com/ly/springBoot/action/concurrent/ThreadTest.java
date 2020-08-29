package com.ly.springBoot.action.concurrent;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2020/6/26 0026 16:00
 */
public class ThreadTest {
    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println(this.getName()+"傻逼");
        }
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            MyThread t = new MyThread();
            //线程start后不会立马就执行处于就绪状态,表示除了cpu的时间片资源外的所有资源就绪,当得到时间片后就开始执行
            t.start();
        }
    }
}
