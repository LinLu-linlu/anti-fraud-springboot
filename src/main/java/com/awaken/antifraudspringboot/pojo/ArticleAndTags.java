package com.awaken.antifraudspringboot.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ArticleAndTags {
    private Article article;
    private ArrayList<String> tags;
}
