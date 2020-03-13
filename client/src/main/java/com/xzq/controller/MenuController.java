package com.xzq.controller;

import com.xzq.entity.Menu;
import com.xzq.entity.MenuVO;
import com.xzq.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @program: mircroservice-demo
 * @description:
 * @author: XZQ
 * @create: 2019-12-25 20:19
 **/
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public MenuVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        return menuFeign.findAll(page, limit);
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") int id) {
        menuFeign.deleteById(id);
        return "redirect:/base/redirect/menu_manage";
    }

    @GetMapping("/types")
    public String findTypes(Model model) {
        model.addAttribute("list", menuFeign.findTypes());
        return "menu_add";
    }

    @PostMapping("/save")
    public String save(Menu menu) {
        menuFeign.save(menu);
        return "redirect:/base/redirect/menu_manage";
    }

    @PostMapping("/update")
    public String update(Menu menu) {
        menuFeign.update(menu);
        return "redirect:/base/redirect/menu_manage";
    }

    @GetMapping("/findById/{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        model.addAttribute("menu", menuFeign.findById(id));
        model.addAttribute("list", menuFeign.findTypes());
        return "menu_update";
    }

}
