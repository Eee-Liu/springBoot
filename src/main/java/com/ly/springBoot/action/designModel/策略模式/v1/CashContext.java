package com.ly.springBoot.action.designModel.策略模式.v1;

import org.springframework.stereotype.Component;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/10/19 14:41
 */
@Component
public class CashContext {
    private CashSuper cashSuper;

    public Double getResult(Double total) {
        return cashSuper.getAmount(total);
    }

    public void getCashSuper(Integer type) {
        switch (type) {
            case 1://打8折
                cashSuper = new CashRebate(0.8);
                break;
            case 2://打5折
                cashSuper = new CashRebate(0.5);
                break;
            case 3://满500减100
                cashSuper = new CashReturn(500D, 100D);
                break;
            default:
                cashSuper = new CashRebate(1D);
                break;
        }
    }
}
