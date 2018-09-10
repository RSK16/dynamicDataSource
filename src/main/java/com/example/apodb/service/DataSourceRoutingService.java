package com.example.apodb.service;

import com.example.apodb.common.ServerResponse;
import com.example.apodb.pojo.User;

/**
 * @program: apodb
 * @description: ${description}
 * @author: zhaokang
 * @create: 2018-09-08 15:20
 **/
public interface DataSourceRoutingService {
    ServerResponse test1(int id);
    ServerResponse test2(int id);
}
