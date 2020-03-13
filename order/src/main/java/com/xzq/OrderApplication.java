package com.xzq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: mircroservice-demo
 * @description: Order启动类
 * @author: XZQ
 * @create: 2019-12-25 16:32
 **/

@SpringBootApplication
@MapperScan("com.xzq.repository")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
