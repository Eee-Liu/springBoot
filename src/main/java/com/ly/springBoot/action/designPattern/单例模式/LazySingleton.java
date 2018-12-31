package com.ly.springBoot.action.designPattern.单例模式;

/**
 * @Author: LiuYi
 * @Description: 懒汉式, 在第一次获取实例的时候才创建.
 * @Date: Created in 2018/12/7 17:35
 */
public class LazySingleton {
    //volatile确保多线程访问数据的唯一性,但是消耗性能
    private volatile static LazySingleton lazySingleton;

    private LazySingleton() {
        //可能有大量初始化自愿操作
    }

    public static LazySingleton getInstance() {
        if (null == lazySingleton) {
            synchronized (LazySingleton.class) {
                //可能线程A获取锁,开实例初始化.但初始化期间线程B也调用getInstance(),通过外层判断实例为null
                //所以此处要二重判断
                if (null == lazySingleton) {
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }
}
