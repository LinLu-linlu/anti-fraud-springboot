package com.awaken.antifraudspringboot.util;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptUtil {

    // 生成密码的哈希值
    public static String hashPassword(String password) {
        // 生成盐的轮次是可以配置的，通常设置为12是一个不错的起点
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    // 验证密码是否匹配哈希值
    public static boolean checkPassword(String rawPassword, String hashedPassword) {
        // BCrypt.checkpw会自动处理盐和哈希值的比较
        return BCrypt.checkpw(rawPassword, hashedPassword);
    }
}
