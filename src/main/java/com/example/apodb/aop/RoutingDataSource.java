package com.example.apodb.aop;

import com.example.apodb.config.DataSources;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: apodb
 * @description: ${description}
 * @author: zhaokang
 * @create: 2018-09-08 10:58
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface RoutingDataSource {

    String value() default DataSources.MASTER_DB;//默认为主数据源
}
