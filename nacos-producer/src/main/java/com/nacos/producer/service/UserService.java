package com.nacos.producer.service;

import com.nacos.producer.entity.User;
import com.nacos.producer.mapper.UserMapper;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @GlobalTransactional
    public User updateUser() {
        log.info("事务ID:" + RootContext.getXID());
        User user = this.userMapper.selectById(1285052338640195585L);
        user.setAge(20);
        this.userMapper.updateById(user);
//        int i = 1/0;
        return user;
    }
}
