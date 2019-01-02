package com.ly.springBoot.action.designPattern.Structural.组合模式;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LiuYi
 * @Description: 公司, 容器部件
 * @Date: Created in 2019/1/2 16:26
 */
public class Company extends Unit {
    private String name;
    private List<Unit> unitList;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Unit> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<Unit> unitList) {
        this.unitList = unitList;
    }

    @Override
    public void add(Unit unit) {
        if (CollectionUtils.isEmpty(unitList)){
            unitList=new ArrayList<>();
        }
        unitList.add(unit);
    }

    @Override
    public void remove(Unit unit) {
        unitList.remove(unit);
    }

    @Override
    public Unit getChilde(Integer index) {
        return unitList.get(index);
    }

    @Override
    public void sendMsg() {
        System.out.println("-----------" + name + "-----------");
        for (Unit unit : unitList) {
            unit.sendMsg();
        }
    }
}
