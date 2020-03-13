package com.xzq.entity;

import lombok.Data;

import java.util.Date;

/**
 * @program: mircroservice-demo
 * @description:
 * @author: XZQ
 * @create: 2019-12-26 16:14
 **/
@Data
public class Account {
    private long id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String telephone;
    private Date registerDate;
    private String address;
}
