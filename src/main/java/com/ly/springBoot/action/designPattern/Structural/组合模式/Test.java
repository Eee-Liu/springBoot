package com.ly.springBoot.action.designPattern.Structural.组合模式;

/**
 * @Author: LiuYi
 * @Description: 组合模式,组合多个对象形成树形结构,表示对象的整体-部分的结构,并且客户端对整体,部分的操作具有一致性
 * @Date: Created in 2019/1/2 16:34
 */
public class Test {
    public static void main(String[] args) {
        Unit HQ,HQIt,HQPersonnel,sh,sz,shIt,shPersonnel,szPersonnel;
        HQ=new Company("总公司");
        sh=new Company("上海分公司");
        sz=new Company("深圳分公司");
        HQIt=new Department("总部it部");
        HQPersonnel=new Department("总部人事部");
        shIt=new Department("上海it部");
        shPersonnel=new Department("上海人事部");
        szPersonnel=new Department("深圳人事部");
        HQ.add(HQIt);
        HQ.add(HQPersonnel);
        HQ.add(sh);
        HQ.add(sz);
        sh.add(shIt);
        sh.add(shPersonnel);
        sz.add(szPersonnel);
        HQ.sendMsg();
    }
}
