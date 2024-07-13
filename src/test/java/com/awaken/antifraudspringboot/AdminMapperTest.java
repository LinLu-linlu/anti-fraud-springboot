package com.awaken.antifraudspringboot;

import com.awaken.antifraudspringboot.mapper.AdminMapper;
import com.awaken.antifraudspringboot.pojo.Admin;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdminMapperTest {
    @Autowired
    private AdminMapper adminMapper;
    @Test
    public void testSelectByUsername(){
        String username = "admin";
        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Admin::getUsername, username);
        Admin admin = adminMapper.selectOne(wrapper);
//        Admin admin = adminMapper.selectById(1L);
        System.out.println(admin);
    }
}
