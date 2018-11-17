package com.ly.springBoot.action.designModel.模版方法模式;

/**
 * @Author: LiuYi
 * @Description: 模版方法模式,定义一个操作中的算法的骨架,而将一些步骤延迟到子类中,模版方法使得子类可以不
 *               改变一个算法的结构即可重新定义该算法的某些特定步骤
 * 就是把公共的代码抽到超类中,一些不同的细节做成抽象方法,让子类去实现父类做具体实现;通过把不变行为搬移到超类,
 * 去除子类中的重复代码来体现她的优势
 * @Date: Created in 2018/11/9 16:52
 */
public class ModelTest {
    public static void main(String[] args) {
        StudentPaperA paperA = new StudentPaperA();
        StudentPaperB paperB = new StudentPaperB();
        paperA.one();
        paperA.two();
        paperA.three();
        System.out.println("------------------------");
        paperB.one();
        paperB.two();
        paperB.three();
    }
}
