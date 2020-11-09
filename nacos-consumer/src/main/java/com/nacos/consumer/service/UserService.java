package com.nacos.consumer.service;

import com.nacos.consumer.entity.User;
import com.nacos.consumer.mapper.UserMapper;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserMapper userMapper;

    @GlobalTransactional
    public String updateUser() {
        log.info("事务ID:" + RootContext.getXID());
        User user = this.userMapper.selectById(1285052338640195585L);
        user.setAge(30);
        this.userMapper.updateById(user);

        String reuslt = restTemplate.getForObject("http://nacos-producer/nacos/producer/producer",String.class);
//        int i = 1/0;
        return reuslt;
    }
}
