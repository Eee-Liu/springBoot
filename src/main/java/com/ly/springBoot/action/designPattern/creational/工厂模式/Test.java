package com.ly.springBoot.action.designPattern.creational.工厂模式;

import com.ly.springBoot.common.SpringContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

/**
 * @Author: LiuYi
 * @Description:
 * @Date: Created in 2018/12/12 14:20
 */
public class Test {
@Autowired
private SpringContext springContext;
    private HashMap readerTypeMap;

    public HashMap getReaderTypeMap() {
        return readerTypeMap;
    }

    public void setReaderTypeMap(HashMap readerTypeMap) {
        this.readerTypeMap = readerTypeMap;
    }

    public void read(String type) throws Exception {
        Object jpg = readerTypeMap.get(type);
        if (null == jpg) {
            System.out.println("不存在该类型");
        }
        //可以从spring容器中取
//        ReaderFactory readerFactory = (ReaderFactory) springContext.getBean(String.valueOf(jpg));
        /**
         * Class.forName()当我传入的字符串的是一个类名时，运行后一直提示java.lang.ClassNotFoundException:这个错误。
         * 当我传入的字符串是  完整的包名+类名  时就可以了
         */
        ReaderFactory readerFactory = (ReaderFactory) Class.forName(String.valueOf(jpg)).newInstance();
        Reader reader = readerFactory.createReader();
        reader.readerPic();
    }
}
