package com.ly.springBoot.action.designModel.策略模式.v1;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: LiuYi
 * @Description: 工厂模式, 实例化的对象经常变化(新增), 这时候可以考虑把不同对象实例化的代码抽成一个工厂类
 * 策略模式,就是用来封装算法的,但在实践中,可以用它来封装几乎任何类型的规则,只要在分析过程中听到需要在不同时间
 * 应用不同的业务规则,就可以考虑使用策略模式处理这种变化的可能性
 * @Date: Created in 2018/10/19 11:03
 */
@Controller
@RequestMapping("/shop")
public class ShopSystemAction {
    @Autowired
    private CashFactory cashFactory;
    @Autowired
    private CashContext cashContext;

    @ResponseBody
    @RequestMapping("/calculate.do")
    public JSONObject calculate(Double price, Integer number, Integer discountsType) {
        //优惠方式有多种并且可能随时新增,所以从工厂中获取获取优惠模式的对象
//        CashSuper cashModel = cashFactory.getCash(discountsType);
//        Double amount = cashModel.getAmount(price * number);
        /**
         *策略模式
         */
        cashContext.getCashSuper(discountsType);
        Double amount = cashContext.getResult(price * number);
        JSONObject result = new JSONObject();
        result.put("amount", amount);
        return result;
    }
}
