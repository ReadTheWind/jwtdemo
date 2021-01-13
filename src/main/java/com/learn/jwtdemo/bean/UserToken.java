package com.learn.jwtdemo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 用户 Token
 * @Author: lh
 * @Date: 2021/1/12 10:11
 **/
@Data
public class UserToken implements Serializable {

    /**
     * 用户ID
     */
    private String userId;


    /**
     * 用户登录账户
     */
    private String userNo;


    /**
     * 用户中文名
     */
    private String userName;


}
