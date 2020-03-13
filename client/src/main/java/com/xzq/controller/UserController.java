package com.xzq.controller;


import com.xzq.entity.User;
import com.xzq.entity.UserVO;
import com.xzq.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


/**
 * @program: mircroservice-demo
 * @description:
 * @author: XZQ
 * @create: 2019-12-25 20:19
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFeign userFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public UserVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        int index = (page - 1) * limit;
        return new UserVO(0, "", userFeign.count(), userFeign.findAll(index, limit));
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") int id) {
        userFeign.deleteById(id);
        return "redirect:/base/redirect/user_manage";
    }

    @PostMapping("/save")
    public String save(User user) {
        user.setRegisterDate(new Date());
        userFeign.save(user);
        return "redirect:/base/redirect/user_manage";
    }

}
