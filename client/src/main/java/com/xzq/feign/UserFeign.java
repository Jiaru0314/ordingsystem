package com.xzq.feign;

import com.xzq.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @program: mircroservice-demo
 * @description: 调用服用提供者
 * @author: XZQ
 * @create: 2019-12-25 20:16
 **/
@FeignClient(value = "user")
public interface UserFeign {

    @GetMapping("/user/findAll/{page}/{limit}")
    List<User> findAll(@PathVariable("page") int page, @PathVariable("limit") int limit);

    @DeleteMapping("/user/deleteById/{id}")
    void deleteById(@PathVariable("id") int id);

    @PutMapping("/user/update")
    void update(@RequestBody User user);

    @PostMapping("/user/save")
    void save(User user);

    @GetMapping("/user/count")
    int count();

    @GetMapping("/user/findById/{id}")
    User findById(@PathVariable("id") int id);
}
