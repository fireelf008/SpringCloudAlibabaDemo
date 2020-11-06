package com.nacos.consumer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nacos.consumer.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
