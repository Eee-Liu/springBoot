package com.ly.springBoot.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/5/9 14:58
 */
@Controller
public class DemoAction {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
