package com.ly.springBoot.action.designModel.策略模式.v1;

import org.springframework.stereotype.Component;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/10/19 11:29
 */
@Component
public class CashFactory {
    private CashSuper cashModel;

    public CashSuper getCash(Integer type) {
        switch (type) {
            case 1://打8折
                cashModel = new CashRebate(0.8);
                break;
            case 2://打5折
                cashModel = new CashRebate(0.5);
                break;
            case 3://满500减100
                cashModel = new CashReturn(500D, 100D);
                break;
            default:
                cashModel = new CashRebate(1D);
                break;
        }
        return cashModel;
    }
}
