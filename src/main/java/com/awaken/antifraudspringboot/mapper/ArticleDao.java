package com.awaken.antifraudspringboot.mapper;

import com.awaken.antifraudspringboot.pojo.ArticlePage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface ArticleDao {
    List<ArticlePage> findByPage(Map<String,Object> params);
    long count();
}
