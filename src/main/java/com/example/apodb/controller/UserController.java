package com.example.apodb.controller;

import com.example.apodb.common.ServerResponse;
import com.example.apodb.service.DataSourceRoutingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: apodb
 * @description: ${description}
 * @author: zhaokang
 * @create: 2018-09-08 15:33
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private DataSourceRoutingService dataSourceRoutingService;

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/1/{id}")
    public ServerResponse getUserById(@PathVariable Integer id){
        return dataSourceRoutingService.test1(id);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/2/{id}")
    public ServerResponse getUserById2(@PathVariable Integer id){
        return dataSourceRoutingService.test2(id);
    }
}

