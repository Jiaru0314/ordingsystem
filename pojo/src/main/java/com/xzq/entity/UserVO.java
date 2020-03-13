package com.xzq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @program: mircroservice-demo
 * @description:
 * @author: XZQ
 * @create: 2019-12-26 11:59
 **/
@Data
@AllArgsConstructor
public class UserVO {
    private int code;
    private String msg;
    private int count;
    private List<User> data;
}
