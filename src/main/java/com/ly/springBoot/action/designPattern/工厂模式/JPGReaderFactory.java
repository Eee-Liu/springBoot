package com.ly.springBoot.action.designPattern.工厂模式;

import org.springframework.stereotype.Component;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/12/12 14:14
 */
@Component
public class JPGReaderFactory implements ReaderFactory{
    @Override
    public Reader createReader() {
        //初始化代码
        return new JPGReader();
    }
}
