package com.awaken.antifraudspringboot.controller;

import com.awaken.antifraudspringboot.entity.Result;
import com.awaken.antifraudspringboot.service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    HttpServletRequest request; //  调用session 用来存储 和获取 用户信息的

    @PostMapping("/login")
    public Result login(@RequestBody HashMap<String,String> map) {
        String username = map.get("username");
        String password = map.get("password");
        Result result = adminService.login(username, password);
        if (result.isFlag()) {
            HttpSession session = request.getSession();
            //  将用户 存到了session中
            session.setAttribute("user", result.getData());
        }
        return result;
    }
}
