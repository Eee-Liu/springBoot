package com.ly.springBoot.action.concurrent;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2020/7/5 0005 22:48
 */
public class UnsafeTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        /**
         * 如果直接在rt.jar包外获取Unsafe会抛异常.因为在getUnsafe()内部会判断是不是Bootstrap类加载器加载的localClass，UnsafeTest.class很明显由AppClassLoader加载的，所以这里直接抛出了异常。
         * Unsafe类是rt.jar包提供的，rt.jar包里面的类是使用Bootstrap类加载器加载的，而我们的启动main函数所在类是使用 AppClassLoader加载的，所以在main函数里面加载Unsafe类时，根据委托机制，会委托给AppClassLoader去加载Unsafe类。
         * 如果没有代码的限制，那么我们的应用程序就可以随意使用Unsafe做事情了，而Unsafe类可以直接操作内存，这是不安全的，所以JDK开发组特意做了这个限制，不让开发人员在正规渠道使用Unsafe类，而是在此jar包里面的核心类中使用nsafe功能。
         */
//        Unsafe unsafe = Unsafe.getUnsafe();
        //使用反射获取unsafe
        Class<Unsafe> unsafeClass = Unsafe.class;
        //使用反射获取Unsafe的成员交量theUnsafe
        Field theUnsafe = unsafeClass.getDeclaredField("theUnsafe");
        //设置为可存取
        theUnsafe.setAccessible(true);
        //获取该变量的值
        Unsafe unsafe = (Unsafe)theUnsafe.get(null);
        System.out.println(unsafe);
    }
}
