package com.nacos.consumer.controller;

import com.nacos.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nacos/consumer")
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/consumer")
    public String consumer() {
        String result = this.userService.updateUser();
        return result;
    }
}