package com.ly.springBoot.action.designPattern.单例模式;

/**
 * @Author: LiuYi
 * @Description: 饿汉式单例, 在类加载时就创建单例对象
 * @Date: Created in 2018/12/7 17:32
 */
public class EagerSingleton {
    private static final EagerSingleton singleton = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return singleton;
    }
}
