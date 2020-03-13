package com.xzq.feign;

import com.xzq.entity.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: mircroservice-demo
 * @description:
 * @author: XZQ
 * @create: 2019-12-26 15:20
 **/
@FeignClient(value = "account")
public interface AccountFeign {

    @GetMapping("/account/login/{username}/{password}/{type}")
    Account login(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("type") String type);
}
