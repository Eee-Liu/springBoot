package com.ly.springBoot.common.log;

import com.ly.springBoot.common.SpringContext;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import com.sun.xml.internal.fastinfoset.util.ValueArray;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.log4mongo.LoggingEventBsonifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

//import org.apache.log4j.AppenderSkeleton;
//import org.apache.log4j.spi.LoggingEvent;

/**
 * @Author: LiuYi
 * @Description: 根据log4j.xml中的layout配置，写日志到mongodb中
 * @Date: Created in 2018/5/24 17:04
 */
@Component
@Lazy(false)
public class MongoAppender extends AppenderSkeleton {
    private static final Logger logger = LoggerFactory.getLogger(MongoAppender.class);
    //资源同步所以加volatile
    private volatile boolean canLog = true;
    private String collectionName;
    private LoggingEventBsonifier bsonifier = new BnqBsonifier();

    @Override
    protected void append(LoggingEvent event) {
        if (!isCanLog()) {
            return;
        }
        //格式化默认日志对象,并转成DBObject
        DBObject bson = null;
        //按照log4j里面配置的layout格式化成json字符串
        String json = layout.format(event);
        if (json.length() > 0) {
            Object parse = JSON.parse(json);
            if (parse instanceof DBObject) {
                bson = (DBObject) parse;
                //putAll重复的key会覆盖,把log4j日志事件对象转化成DBObject并设置bson内容
                bson.putAll(bsonifier.bsonify(event));
            }
        }

        if (null != bson) {
            //往mongo中插日志
            MongoTemplate mongoTemplate = SpringContext.getBean("mongoTemplate");
            if (null == mongoTemplate) {
                logger.error("init spring bean mongoTemplate err");
                return;
            }
            //TODO 可改造为使用多线程insert
            mongoTemplate.insert(bson, getCollectionName());
        }
    }

    @Override
    public void close() {
        canLog = false;
    }

    private boolean isCanLog() {
        return canLog;
    }

    @Override
    public boolean requiresLayout() {
        return false;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }
}
