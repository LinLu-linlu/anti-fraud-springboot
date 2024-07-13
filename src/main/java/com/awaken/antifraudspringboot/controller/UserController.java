package com.awaken.antifraudspringboot.controller;

import com.awaken.antifraudspringboot.entity.PageResult;
import com.awaken.antifraudspringboot.entity.QueryPageBean;
import com.awaken.antifraudspringboot.entity.Result;
import com.awaken.antifraudspringboot.pojo.User;
import com.awaken.antifraudspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/all")
    public Result getAllUser(){
        return userService.getAllUsers();
    }

    @PostMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        return userService.findByPage(queryPageBean);
    }

    @GetMapping("/selectById")
    public Result selectById(Integer id){
        return userService.selectById(id);
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user){
        return userService.update(user);
    }

    @GetMapping("/banUser")
    public Result banUser(Integer id){
        return userService.banUser(id);
    }

    @GetMapping("/unBanUser")
    public Result unBanUser(Integer id){
        return userService.unBanUser(id);
    }
}