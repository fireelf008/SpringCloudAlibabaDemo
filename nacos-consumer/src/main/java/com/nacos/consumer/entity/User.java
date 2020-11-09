package com.nacos.consumer.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("tb_user")
public class User implements Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String username;
    private String pwd;
    private String sex;
    private Integer age;
    private Date birthday;

    @TableLogic
    private Integer enabled;

    @Version
    private Integer version;
}
