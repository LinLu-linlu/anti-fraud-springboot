package com.awaken.antifraudspringboot.service;

import com.awaken.antifraudspringboot.entity.PageResult;
import com.awaken.antifraudspringboot.entity.QueryPageBean;
import com.awaken.antifraudspringboot.entity.Result;
import com.awaken.antifraudspringboot.pojo.User;

public interface UserService {

    Result getAllUsers();

    PageResult findByPage(QueryPageBean queryPageBean);

    Result selectById(Integer id);

    Result update(User user);

    Result banUser(Integer id);

    Result unBanUser(Integer id);
}
