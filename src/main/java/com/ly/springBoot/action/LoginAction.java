package com.ly.springBoot.action;

import com.alibaba.fastjson.JSONObject;
import com.ly.springBoot.common.SpringContext;
import com.ly.springBoot.domain.PersonDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/5/15 11:45
 */
@Controller
@RequestMapping("/auth")
public class LoginAction {
    Logger logger = LoggerFactory.getLogger("mongoLogger");
    @RequestMapping("/login.view")
    public String loginView(){
        logger.info("info日志");
        logger.error("error日志");
        return "login";
    }

    @ResponseBody
    @RequestMapping("/login.do")
    public JSONObject login(@RequestBody PersonDO personDO, HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject result = new JSONObject();
        if ("springBoot".equals(personDO.getAccount())&&"123456".equals(personDO.getPwd())){
            request.getSession().setAttribute("sessionDO",personDO);
            result.put("code",0);
            result.put("message","ok");
//            response.sendRedirect("/index");
        }else {
            result.put("code","-1");
            result.put("message","帐号密码不匹配");
        }
        return result;
    }
}
