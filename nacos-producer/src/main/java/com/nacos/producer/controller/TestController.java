package com.nacos.producer.controller;

import com.nacos.producer.service.UserService;
import com.nacos.producer.utils.JvmUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nacos/producer")
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/producer")
    public String producer(){

        this.userService.updateUser();
        return "你好，" + JvmUtils.getJvmId();
    }
}
