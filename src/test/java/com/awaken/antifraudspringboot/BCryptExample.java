package com.awaken.antifraudspringboot;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptExample {

    // 生成密码的哈希值  
    public static String hashPassword(String password) {
        // 生成盐的轮次是可以配置的，通常设置为12是一个不错的起点

        // gensalt会生成一个随机的盐，并将其与哈希值一起返回
        // 12是盐的轮次，轮次越高，哈希计算越慢，安全性越高
//        String salt = BCrypt.gensalt(12);
        String salt = "$2a$12$PDtS29OgerftXlL8DzpExu";
        System.out.println("salt:" + salt);
        String hashedPassword = BCrypt.hashpw(password, salt);
        System.out.println(hashedPassword.length());
        return hashedPassword;
    }

    // 验证密码是否匹配哈希值
    public static boolean checkPassword(String rawPassword, String hashedPassword) {
        // BCrypt.checkpw会自动处理盐和哈希值的比较  
        return BCrypt.checkpw(rawPassword, hashedPassword);
    }

    public static void main(String[] args) {
        // 假设有一个用户密码
        String password = "21232f297a57a5a743894a0e4a801fc3";

        // 生成密码的哈希值  
        String hashedPassword = hashPassword(password);

        // 输出哈希值（实际应用中不应直接输出或存储明文哈希值）  
        System.out.println("Hashed Password: " + hashedPassword);

        // 验证密码  
        boolean isMatch = checkPassword(password, hashedPassword);

        // 输出验证结果  
        System.out.println("Is Password Match? " + isMatch);

        // 尝试使用错误的密码进行验证  
        boolean isWrongMatch = checkPassword("21232f297a57a5a743894a0e4a801fc", hashedPassword);

        // 输出验证结果  
        System.out.println("Is Wrong Password Match? " + isWrongMatch);
    }
}