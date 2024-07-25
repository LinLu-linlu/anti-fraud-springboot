package com.awaken.antifraudspringboot.service;

import com.awaken.antifraudspringboot.entity.PageResult;
import com.awaken.antifraudspringboot.entity.QueryPageBean;

public interface QuestionService {

    PageResult findByPage(QueryPageBean queryPageBean);
}
