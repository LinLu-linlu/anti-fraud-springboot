package com.awaken.antifraudspringboot.service.impl;

import com.awaken.antifraudspringboot.entity.PageResult;
import com.awaken.antifraudspringboot.entity.QueryPageBean;
import com.awaken.antifraudspringboot.entity.Result;
import com.awaken.antifraudspringboot.mapper.UserDao;
import com.awaken.antifraudspringboot.mapper.UserMapper;
import com.awaken.antifraudspringboot.pojo.User;
import com.awaken.antifraudspringboot.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserDao userDao;

    @Override
    public Result getAllUsers() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(User::getId, User::getUsername, User::getNickname);
        List<User> users = userMapper.selectList(wrapper);
        if (users == null || users.isEmpty()) {
            return new Result(false, "获取失败");
        }
        return new Result(true, "成功", users);
    }

    @Override
    public PageResult findByPage(QueryPageBean queryPageBean) {
        int page = queryPageBean.getCurrentPage();
        int size = queryPageBean.getPageSize();
        Map<String, Object> params = new HashMap<>();
        params.put("page", (page - 1) * size);
        params.put("size", size);
        params.put("queryString", queryPageBean.getQueryString());
        List<User> users;
        PageResult pageResult = new PageResult();
        users = userDao.findByPage(params);
        pageResult.setData(users);
        pageResult.setTotal(userDao.count());
        return pageResult;
    }

    @Override
    public Result selectById(Integer id) {
        User user = userMapper.selectById(id);
        if (user == null) {
            return new Result(false, "失败");
        }
        return new Result(true, "成功", user);
    }

    @Override
    public Result update(User user) {
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(User::getUsername, user.getUsername())
                .set(User::getNickname, user.getNickname())
                .set(User::getScore, user.getScore())
                .eq(User::getId, user.getId());
        int num = userMapper.update(null, wrapper);
        if (num <= 0) {
            return new Result(false, "失败");
        }
        return new Result(true, "成功");
    }

    @Override
    public Result banUser(Integer id) {
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(User::getState, 1)
                .eq(User::getId, id);
        int num = userMapper.update(null, wrapper);
        if (num <= 0) {
            return new Result(false, "失败");
        }
        return new Result(true, "成功");
    }

    @Override
    public Result unBanUser(Integer id) {
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        wrapper.set(User::getState, 0)
                .eq(User::getId, id);
        int num = userMapper.update(null, wrapper);
        if (num <= 0) {
            return new Result(false, "失败");
        }
        return new Result(true, "成功");
    }
}