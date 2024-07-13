package com.awaken.antifraudspringboot.service.impl;

import com.awaken.antifraudspringboot.entity.PageResult;
import com.awaken.antifraudspringboot.entity.QueryPageBean;
import com.awaken.antifraudspringboot.entity.Result;
import com.awaken.antifraudspringboot.mapper.ArticleDao;
import com.awaken.antifraudspringboot.mapper.ArticleMapper;
import com.awaken.antifraudspringboot.mapper.ArticleTagMapper;
import com.awaken.antifraudspringboot.pojo.Article;
import com.awaken.antifraudspringboot.pojo.ArticlePage;
import com.awaken.antifraudspringboot.pojo.ArticleTag;
import com.awaken.antifraudspringboot.service.ArticleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleDao articleDao;

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    ArticleTagMapper articleTagMapper;

    @Override
    public PageResult findByPage(QueryPageBean queryPageBean) {
        int page = queryPageBean.getCurrentPage();
        int size = queryPageBean.getPageSize();
        Map<String, Object> params = new HashMap<>();
        params.put("page", (page - 1) * size);
        params.put("size", size);
        params.put("queryString", queryPageBean.getQueryString());
        List<ArticlePage> articles;
        PageResult pageResult = new PageResult();
        articles = articleDao.findByPage(params);
        pageResult.setData(articles);
        pageResult.setTotal(articleDao.count());
        return pageResult;
    }

    @Override
    public Result insertArticle(Article article, List<String> tags) {
        int count = articleMapper.insert(article);
        if (count <= 0) {
            return new Result(false, "失败");
        }
        for (String tag : tags) {
            ArticleTag articleTag = new ArticleTag();
            articleTag.setAid(article.getId());
            articleTag.setTag(tag);
            articleTagMapper.insert(articleTag);
        }
        return new Result(true, "成功");
    }

    @Override
    public Result deleteArticle(Integer id) {
        //先删除tag的表的标签 再删除article表的文章
        LambdaQueryWrapper<ArticleTag> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ArticleTag::getAid, id);
        articleTagMapper.delete(wrapper);
        int count = articleMapper.deleteById(id);
        if (count <= 0) {
            return new Result(false, "失败");
        }
        return new Result(true, "成功");
    }

    @Override
    public Result selectById(Integer id) {
        Article article = articleMapper.selectById(id);
        if (article == null) {
            return new Result(false, "失败");
        }
        return new Result(true, "成功", article);
    }

    @Override
    public Result selectTagById(Integer id) {
        LambdaQueryWrapper<ArticleTag> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ArticleTag::getAid, id).select(ArticleTag::getTag);
        List<ArticleTag> articleTags = articleTagMapper.selectList(wrapper);
        List<String> tags = new ArrayList<>();
        for (ArticleTag articleTag : articleTags) {
            tags.add(articleTag.getTag());
        }
        return new Result(true, "成功", tags);
    }

    @Override
    public Result updateArticle(Article article, ArrayList<String> tags) {
        LambdaQueryWrapper<ArticleTag> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ArticleTag::getAid, article.getId());
        articleTagMapper.delete(wrapper);
        articleMapper.updateById(article);
        for (String tag : tags) {
            ArticleTag articleTag = new ArticleTag();
            articleTag.setAid(article.getId());
            articleTag.setTag(tag);
            articleTagMapper.insert(articleTag);
        }
        return new Result(true, "成功");
    }
}