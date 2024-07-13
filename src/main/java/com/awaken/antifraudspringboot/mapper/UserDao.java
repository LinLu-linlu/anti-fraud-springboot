package com.awaken.antifraudspringboot.mapper;

import com.awaken.antifraudspringboot.pojo.ArticlePage;
import com.awaken.antifraudspringboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {
    List<User> findByPage(Map<String,Object> params);
    long count();
}
