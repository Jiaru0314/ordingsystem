package com.xzq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: mircroservice-demo
 * @description:
 * @author: XZQ
 * @create: 2019-12-25 17:15
 **/
@SpringBootApplication
@MapperScan("com.xzq.repository")
public class MenuApplicaion {
    public static void main(String[] args) {
        SpringApplication.run(MenuApplicaion.class, args);
    }
}
