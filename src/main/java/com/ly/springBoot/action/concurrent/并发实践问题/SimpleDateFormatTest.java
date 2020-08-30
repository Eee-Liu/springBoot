package com.ly.springBoot.action.concurrent.并发实践问题;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2020/8/30 0030 11:28
 */
public class SimpleDateFormatTest {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-sss");

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(sdf.parse("2020-08-28 11:11:111"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }
}
