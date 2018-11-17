package com.ly.springBoot.action.designModel.装饰模式;

/**
 * @Author: LiuYi
 * @Description: 装饰模式是为已有的功能动态添加更多功能的一种方式.
 * 如该例中的person.show()是已有的功能,我们可以通过装饰模式创建person的子类,在person.show()之前动态的添加更多的功能
 * @Date: Created in 2018/11/7 20:38
 */
public class DecoratorMOdel {
    public static void main(String[] args) {
        Person liuyi = new Person("liuyi");
        TShirts tShirts = new TShirts();
        Pants pants = new Pants();
        tShirts.setPerson(liuyi);
        pants.setPerson(tShirts);
        pants.show();
    }
}
