package com.awaken.antifraudspringboot.entity;

import lombok.Data;

import java.util.List;

@Data
public class PageResult {

    private long total; //总记录条数
    private List data; //返回的记录
}
