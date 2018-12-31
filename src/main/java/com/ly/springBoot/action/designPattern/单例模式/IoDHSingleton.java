package com.ly.springBoot.action.designPattern.单例模式;

/**
 * @Author: LiuYi
 * @Description: 结合饿汉式跟懒汉式的优点,1.在使用时再初始化实例 2.避免多线程的繁琐
 * 思想:1.创建一个静态内部类,需要单例的实例作为这个类的变量; 2.提供外部一个获取该类内,单例实例的方法
 * @Date: Created in 2018/12/7 17:47
 */
public class IoDHSingleton {

    private IoDHSingleton() {
    }

    //由于singleton,不是IoDHSingleton的成员变量.所以在加载时不会创建单例实例
    private static class HolderClass{
        private static final IoDHSingleton singleton = new IoDHSingleton();
    }

    //在第一次调用getInstance()时,会初始化内部类HolderClass,并初始化其成员变量,创建单例.
    //因为类只会被加载一次,所以不需要考虑多线程的问题,多线程的问题由Java虚拟机保证
    public static IoDHSingleton getInstance(){
        return HolderClass.singleton;
    }
}
