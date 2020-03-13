package com.xzq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @program: mircroservice-demo
 * @description:
 * @author: XZQ
 * @create: 2019-12-25 21:20
 **/
@Data
@AllArgsConstructor
public class MenuVO {

    private int code;
    private String msg;
    private int count;
    private List<Menu> data;
}
