package com.awaken.antifraudspringboot.entity;

import com.awaken.antifraudspringboot.pojo.ArticlePage;
import lombok.Data;

import java.util.List;

@Data
public class PageResult {
//    private int page; //分页起始页
//    private int pageSize; //每页大小（数据条数）
    private long total; //总记录条数
    private List data; //返回的记录
}
