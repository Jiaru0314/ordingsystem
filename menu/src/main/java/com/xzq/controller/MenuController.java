package com.xzq.controller;

import com.xzq.entity.Type;
import com.xzq.repository.MenuRepository;
import com.xzq.entity.Menu;
import com.xzq.entity.MenuVO;
import com.xzq.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @program: mircroservice-demo
 * @description:
 * @author: XZQ
 * @create: 2019-12-25 17:16
 **/
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private TypeRepository typeRepository;

    @GetMapping("/index")
    public String index() {
        return "当前的端口是" + this.port;
    }

    @PostMapping("/save")
    public void save(@RequestBody Menu menu) {
        menuRepository.save(menu);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") int id) {
        menuRepository.deleteById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Menu menu) {
        menuRepository.update(menu);
    }

    @GetMapping("/findAll/{page}/{limit}")
    public MenuVO findAll(@PathVariable("page") int page, @PathVariable("limit") int limit) {
        int index = (page - 1) * limit;
        return new MenuVO(0, "", menuRepository.count(), menuRepository.findAll(index, limit));
    }

    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") int id) {
        return menuRepository.findById(id);
    }

    @GetMapping("/count")
    public int count() {
        return menuRepository.count();
    }

    @GetMapping("/types")
    public List<Type> findTypes() {
        return typeRepository.findAll();
    }


}
