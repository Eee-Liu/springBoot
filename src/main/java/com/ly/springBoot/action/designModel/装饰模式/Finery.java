package com.ly.springBoot.action.designModel.装饰模式;

/**
 * @Author: LiuYi
 * @Description: 服饰
 * @Date: Created in 2018/11/7 20:30
 */
public class Finery extends Person{
    protected Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    public void show() {
        if (null != person) {
            person.show();
        }
    }
}
