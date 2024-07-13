package com.awaken.antifraudspringboot.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ChartsDao {
    List<Map<String,Object>> getWeekCountArticle();

    List<Map<String,Object>> getMostTag();
}
