package com.nacos.consumer.service;

import com.nacos.consumer.entity.User;
import com.nacos.consumer.mapper.UserMapper;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserMapper userMapper;

    @GlobalTransactional
    public String updateUser() {
        User user = this.userMapper.selectById(1285052338640195585L);
        user.setAge(30);
        int i = 1/0;
        this.userMapper.updateById(user);
        String reuslt = restTemplate.getForObject("http://nacos-producer/nacos/producer/producer",String.class);
        return reuslt;
    }
}
