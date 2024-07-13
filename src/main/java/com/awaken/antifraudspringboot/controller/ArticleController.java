package com.awaken.antifraudspringboot.controller;

import com.awaken.antifraudspringboot.entity.PageResult;
import com.awaken.antifraudspringboot.entity.QueryPageBean;
import com.awaken.antifraudspringboot.entity.Result;
import com.awaken.antifraudspringboot.pojo.Article;
import com.awaken.antifraudspringboot.pojo.ArticleAndTags;
import com.awaken.antifraudspringboot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @PostMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        return articleService.findByPage(queryPageBean);
    }

    @PostMapping("/add")
    public Result add(@RequestBody ArticleAndTags articleAndTags) {
        System.out.println("articleAndTags: " + articleAndTags);
        Article article = articleAndTags.getArticle();
        System.out.println("article: " + article);
        ArrayList<String> tags = articleAndTags.getTags();
        return articleService.insertArticle(article, tags);
    }

    @GetMapping("/delete")
    public Result delete(Integer id){
        return articleService.deleteArticle(id);
    }

    @GetMapping("/selectById")
    public Result selectById(Integer id){
        return articleService.selectById(id);
    }

    @GetMapping("/selectTagById")
    public Result selectTagById(Integer id){
        return articleService.selectTagById(id);
    }

    @PostMapping("/update")
    public Result update(@RequestBody ArticleAndTags articleAndTags) {
        System.out.println("articleAndTags: " + articleAndTags);
        Article article = articleAndTags.getArticle();
        System.out.println("article: " + article);
        ArrayList<String> tags = articleAndTags.getTags();
        return articleService.updateArticle(article, tags);
    }
}