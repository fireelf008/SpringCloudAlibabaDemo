package com.nacos.producer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nacos.producer.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
