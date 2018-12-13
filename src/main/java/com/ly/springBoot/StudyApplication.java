package com.ly.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @SpringBootApplication 被 @Configuration、@EnableAutoConfiguration、@ComponentScan
 * 注解所修饰，换言之 Springboot 提供了统一的注解来替代以上三个注解，简化程序的配置。
 */
@SpringBootApplication()
@ImportResource(locations = {"classpath:spring-main.xml"})
//@ComponentScan(basePackages = {"com.ly.springBoot.action"})
public class StudyApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
	}
}
