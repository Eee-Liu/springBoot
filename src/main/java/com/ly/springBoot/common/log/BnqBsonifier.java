package com.ly.springBoot.common.log;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.apache.log4j.spi.LoggingEvent;
import org.log4mongo.LoggingEventBsonifier;
import org.log4mongo.LoggingEventBsonifierImpl;

import java.util.Date;

/**
 * @Author: LiuYi
 * @Description: 解析LoggingEvent,生成自己需要的日志信息的DBObject对象
 * @Date: Created in 2018/6/27 11:06
 */
public class BnqBsonifier extends LoggingEventBsonifierImpl {

    private static final String KEY_LOGGER_NAME = "loggerName";
    public static final String KEY_LOG_MSG = "msg";

    //日志时间
    public static final String KEY_LOGGER_DateUTC = "dateUTC";

    @Override
    public DBObject bsonify(final LoggingEvent loggingEvent) {
        DBObject result = null;

        if (loggingEvent != null) {
            result = new BasicDBObject();
            //TODO 请求信息

            //代码出错信息
            nullSafePut(result, KEY_LOGGER_NAME, loggingEvent.getLoggerName());
            nullSafePut(result, KEY_LOG_MSG, loggingEvent.getMessage());
            nullSafePut(result, KEY_LOGGER_DateUTC, new Date(loggingEvent.getTimeStamp()));

//            addMDCInformation(result, loggingEvent.getProperties());
//            addLocationInformation(result, loggingEvent.getLocationInformation());
            //添加抛出的错误信息
            addThrowableInformation(result, loggingEvent.getThrowableInformation());
            //添加ip信息
            addHostnameInformation(result);
        }

        return (result);
    }
}
