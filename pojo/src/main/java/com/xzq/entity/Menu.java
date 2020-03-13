package com.xzq.entity;

import lombok.Data;

/**
 * @program: mircroservice-demo
 * @description:
 * @author: XZQ
 * @create: 2019-12-25 19:10
 **/
@Data
public class Menu {

    private Long id;
    private String name;
    private double price;
    private String flavor;
    private Type type;

}
