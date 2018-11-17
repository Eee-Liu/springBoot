package com.ly.springBoot.action.designModel.策略模式.v1;

/**
 * @Author: LiuYi
 * @Description: 打折
 * @Date: Created in 2018/10/19 11:23
 */
public class CashRebate implements CashSuper {
    private Double rebate;

    public CashRebate(Double rebate) {
        this.rebate = rebate;
    }

    @Override
    public Double getAmount(Double total) {
        return total * rebate;
    }
}
