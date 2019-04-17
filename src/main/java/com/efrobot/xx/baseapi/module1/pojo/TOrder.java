package com.efrobot.xx.baseapi.module1.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: wurui
 * @create: 2019-04-10 21:38
 **/

@Data
public class TOrder {
    private Long id;
    private Integer userId;
    private Date createTime;
}
