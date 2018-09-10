package com.example.apodb.service.impl;

import com.example.apodb.aop.RoutingDataSource;
import com.example.apodb.common.ServerResponse;
import com.example.apodb.dao.UserMapper;
import com.example.apodb.service.DataSourceRoutingService;
import com.example.apodb.config.DataSources;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: apodb
 * @description: ${description}
 * @author: zhaokang
 * @create: 2018-09-08 15:14
 **/
@Service
public class DataSourceRoutingServiceImpl implements DataSourceRoutingService {

    @Resource
    private UserMapper sysUserMapper;

    @RoutingDataSource(DataSources.MASTER_DB) // 这个注解这时是可以省略，因为默认就是访问主库
    public ServerResponse test1(int id) {
        return ServerResponse.createBySuccess(sysUserMapper.selectByPrimaryKey(id));
    }

    @RoutingDataSource(DataSources.SLAVE_DB)
    public ServerResponse test2(int id) {
        return ServerResponse.createBySuccess(sysUserMapper.selectByPrimaryKey(id));
    }

}