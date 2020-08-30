package com.ly.springBoot.action.concurrent.线程池;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: LiuYi
 * @Description: 使用线程池执行定时任务测试
 * @Date: Created in 2020/8/30 0030 15:44
 */
public class ScheduledThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        //以period为固定频率间隔执行任务.如果任务执行时间小于period,则上次任务执行完成后会间隔period后再去执行下一次任务；
        // 但如果任务执行时间大于period，则上次任务执行完毕后会不间隔的立即开始下次任务
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            private int count;
            @Override
            public void run() {
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = sdf.format(new Date());
                System.out.println(time + "第" + (++count) + "执行");
            }
        }, 0, 2000, TimeUnit.MILLISECONDS);
        //是不管任务执行多久，都会等上一次任务执行完毕后再延迟delay后去执行下次任务
//        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
//            private int count;
//
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(3000L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                String time = DateUtil.dateToString(new Date(), DateUtil.Format_1);
//                System.out.println(time + "第" + (++count) + "执行");
//            }
//        }, 0, 2000, TimeUnit.MILLISECONDS);
    }
}
