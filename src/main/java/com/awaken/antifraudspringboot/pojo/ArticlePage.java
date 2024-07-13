package com.awaken.antifraudspringboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticlePage {
    private int id;
    private String author_name;
    private String content;
    private String dateTime;
    private String title;
    private String img;
    private int type;
}
