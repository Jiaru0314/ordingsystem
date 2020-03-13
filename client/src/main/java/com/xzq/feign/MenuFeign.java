package com.xzq.feign;

import com.xzq.entity.Menu;
import com.xzq.entity.MenuVO;
import com.xzq.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @program: mircroservice-demo
 * @description: 调用服用提供者
 * @author: XZQ
 * @create: 2019-12-25 20:16
 **/
@FeignClient(value = "menu")
public interface MenuFeign {

    @GetMapping("/menu/findAll/{page}/{limit}")
    MenuVO findAll(@PathVariable("page") int page, @PathVariable("limit") int limit);

    @DeleteMapping("/menu/deleteById/{id}")
    void deleteById(@PathVariable("id") int id);

    @PutMapping("/menu/update")
    void update(@RequestBody Menu menu);

    @GetMapping("/menu/types")
    List<Type> findTypes();

    @PostMapping("/menu/save")
    void save(Menu menu);

    @GetMapping("/menu/findById/{id}")
    Menu findById(@PathVariable("id") int id);
}
