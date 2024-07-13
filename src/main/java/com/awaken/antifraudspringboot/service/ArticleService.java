package com.awaken.antifraudspringboot.service;

import com.awaken.antifraudspringboot.entity.PageResult;
import com.awaken.antifraudspringboot.entity.QueryPageBean;
import com.awaken.antifraudspringboot.entity.Result;
import com.awaken.antifraudspringboot.pojo.Article;

import java.util.ArrayList;
import java.util.List;

public interface ArticleService {
    PageResult findByPage(QueryPageBean queryPageBean);

    Result insertArticle(Article article, List<String> tags);

    Result deleteArticle(Integer id);

    Result selectById(Integer id);

    Result selectTagById(Integer id);

    Result updateArticle(Article article, ArrayList<String> tags);
}
