package com.nacos.producer.test;

import com.nacos.producer.NacosProducerApplication;
import com.nacos.producer.entity.User;
import com.nacos.producer.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {NacosProducerApplication.class})
public class MyTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList.size());
    }
}
