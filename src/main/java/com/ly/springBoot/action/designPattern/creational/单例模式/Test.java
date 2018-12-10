package com.ly.springBoot.action.designPattern.creational.单例模式;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/12/7 17:57
 */
public class Test {
    public static void main(String[] args) {
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        EagerSingleton eagerSingleton2 = EagerSingleton.getInstance();
        if (eagerSingleton == eagerSingleton2) {
            System.out.println("饿汉式OK");
        }

        LazySingleton lazySingleton = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();
        if (lazySingleton == lazySingleton2) {
            System.out.println("懒汉式OK");
        }

        IoDHSingleton ioDHSingleton = IoDHSingleton.getInstance();
        IoDHSingleton ioDHSingleton2 = IoDHSingleton.getInstance();
        if (ioDHSingleton == ioDHSingleton2) {
            System.out.println("ioDH式OK");
        }
    }
}
