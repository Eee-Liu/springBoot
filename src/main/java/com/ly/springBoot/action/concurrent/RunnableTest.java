package com.ly.springBoot.action.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2020/6/26 0026 16:07
 */
public class RunnableTest {
    public static class RunTask implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"唇膜");
        }
    }

    public static class CallTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            return Thread.currentThread().getName()+"憨批";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        RunTask runTask = new RunTask();
//        for (int i = 1; i <= 10; i++) {
//            Thread thread = new Thread(runTask);
//            thread.start();
//        }
        CallTask callTask = new CallTask();

        for (int i = 1; i <= 100; i++) {
            FutureTask<String> stringFutureTask = new FutureTask<>(callTask);
            Thread thread = new Thread(stringFutureTask);
            thread.start();
            String s = stringFutureTask.get();
            System.out.println(s);
        }

    }
}
