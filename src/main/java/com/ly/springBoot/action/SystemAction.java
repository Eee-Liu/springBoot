package com.ly.springBoot.action;

import com.ly.springBoot.domain.SystemEntity;
import com.ly.springBoot.jpa.SystemJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/5/9 15:25
 */
@RestController
@RequestMapping("/system")
public class SystemAction {
    @Autowired
    private SystemJpa systemJpa;

    @RequestMapping(value = "/list.do",method = RequestMethod.GET)
    public List<SystemEntity> list(){
        return systemJpa.findAll();
    }

    @RequestMapping(value = "/queryByCode.do",method = RequestMethod.GET)
    public SystemEntity queryByCode(String code){
        return systemJpa.queryByCode(code);
    }
}
