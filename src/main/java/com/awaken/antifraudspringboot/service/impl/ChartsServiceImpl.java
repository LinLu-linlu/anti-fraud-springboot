package com.awaken.antifraudspringboot.service.impl;

import com.awaken.antifraudspringboot.mapper.ChartsDao;
import com.awaken.antifraudspringboot.service.ChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChartsServiceImpl implements ChartsService {
    @Autowired
    private ChartsDao chartsDao;
    @Override
    public List<Map<String, Object>> getWeekCountArticle() {
        return chartsDao.getWeekCountArticle();
    }

    @Override
    public List<Map<String, Object>> getMostTag() {
        return chartsDao.getMostTag();
    }
}
