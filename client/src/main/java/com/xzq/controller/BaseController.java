package com.xzq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: mircroservice-demo
 * @description:
 * @author: XZQ
 * @create: 2019-12-26 14:57
 **/
@Controller
@RequestMapping("/base")
public class BaseController {

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location) {
        return location;
    }
}
