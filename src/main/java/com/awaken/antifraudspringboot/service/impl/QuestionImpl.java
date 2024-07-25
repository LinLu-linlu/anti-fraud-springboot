package com.awaken.antifraudspringboot.service.impl;

import com.awaken.antifraudspringboot.entity.PageResult;
import com.awaken.antifraudspringboot.entity.QueryPageBean;
import com.awaken.antifraudspringboot.service.QuestionService;
import org.springframework.stereotype.Service;

@Service
public class QuestionImpl implements QuestionService {
    @Override
    public PageResult findByPage(QueryPageBean queryPageBean) {
        return null;
    }
}
