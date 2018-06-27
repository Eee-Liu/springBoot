package com.ly.springBoot.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * spring上下文
 * Created by nikohan on 2017/7/9.
 */
@Component
public class SpringContext implements ApplicationContextAware {

	private final static Logger logger = LoggerFactory.getLogger(SpringContext.class);

	//通过ApplicationContextAware方式注入
	private static ApplicationContext applicationContext;

	@SuppressWarnings("static-access")
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName) throws RuntimeException {
		ApplicationContext applicationContext = getApplicationContext();
		if (null == applicationContext) {
			return null;
		}

		return (T) applicationContext.getBean(beanName);
	}

	public static <T> T getBean(Class<T> requiredType) throws RuntimeException {
		ApplicationContext applicationContext = getApplicationContext();
		if (null == applicationContext) {
			return null;
		}

		return applicationContext.getBean(requiredType);
	}

	public static void refresh() {
		logger.info("refresh spring config starting...");

		if (null != applicationContext) {
			((ConfigurableApplicationContext) applicationContext).refresh();
		}

		logger.info("refresh spring config finished.");
	}
}
