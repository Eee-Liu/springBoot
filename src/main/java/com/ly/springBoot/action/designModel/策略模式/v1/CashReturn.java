package com.ly.springBoot.action.designModel.策略模式.v1;

/**
 * @Author: LiuYi
 * @Description: 满减
 * @Date: Created in 2018/10/19 11:25
 */
public class CashReturn implements CashSuper {
    private Double moneyCondition;
    private Double moneyReturn;

    public CashReturn(Double moneyCondition, Double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public Double getAmount(Double total) {
        if (total >= moneyCondition) {
            return total - moneyReturn;
        }
        return total;
    }
}
