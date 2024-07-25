package com.awaken.antifraudspringboot.service.impl;

import com.awaken.antifraudspringboot.entity.Result;
import com.awaken.antifraudspringboot.mapper.AdminMapper;
import com.awaken.antifraudspringboot.pojo.Admin;
import com.awaken.antifraudspringboot.service.AdminService;
import com.awaken.antifraudspringboot.util.BCryptUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Result login(String username, String password) {
        if (username == null || password == null) {
            return new Result(false, "登录名或密码为空");
        }
        // select * from t_user where username = username
        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Admin::getUsername, username);
        Admin admin = adminMapper.selectOne(wrapper);

        if (admin == null) {
            return new Result(false, "登录名或密码错误");
        }
        // 数据库查出来的密码
        String pwdDb = admin.getPassword();

        if (!BCryptUtil.checkPassword(password, pwdDb)) {
            return new Result(false, "登录名或密码错误");
        }
        return new Result(true, "登录成功");
    }
}
