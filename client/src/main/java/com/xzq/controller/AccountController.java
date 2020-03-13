package com.xzq.controller;

import com.xzq.entity.Account;
import com.xzq.entity.Admin;
import com.xzq.entity.User;
import com.xzq.feign.AccountFeign;
import com.xzq.utils.ReflectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @program: mircroservice-demo
 * @description:
 * @author: XZQ
 * @create: 2019-12-26 15:19
 **/
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountFeign accountFeign;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type, HttpSession session) {
        Account account = accountFeign.login(username, password, type);
        String target = null;
        if (account == null) {
            target = "login";
        } else {
            switch (type) {
                case "user":
                    User user = convertUser(account);
                    session.setAttribute("user", user);
                    target = "redirect:/base/redirect/index";
                    break;
                case "admin":
                    Admin admin = convertAdmin(account);
                    session.setAttribute("admin", admin);
                    target = "redirect:/base/redirect/main";
                    break;
            }
        }
        return target;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }

    private User convertUser(Account account) {
        User user = new User();
        user.setUsername(ReflectUtils.getFieldValue(account, "username") + "");
        user.setPassword(ReflectUtils.getFieldValue(account, "password") + "");
        user.setGender(ReflectUtils.getFieldValue(account, "gender") + "");
        user.setId((long) (ReflectUtils.getFieldValue(account, "id")));
        user.setNickname(ReflectUtils.getFieldValue(account, "nickname") + "");
        user.setRegisterDate((Date) (ReflectUtils.getFieldValue(account, "registerDate")));
        user.setTelephone(ReflectUtils.getFieldValue(account, "telephone") + "");
        return user;
    }

    private Admin convertAdmin(Account account) {
        Admin admin = new Admin();
        admin.setUsername(ReflectUtils.getFieldValue(account, "username") + "");
        admin.setPassword(ReflectUtils.getFieldValue(account, "password") + "");
        admin.setId((long) (ReflectUtils.getFieldValue(account, "id")));
        return admin;
    }

}
