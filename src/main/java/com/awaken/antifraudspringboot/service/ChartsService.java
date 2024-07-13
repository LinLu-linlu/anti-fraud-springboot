package com.awaken.antifraudspringboot.service;


import com.awaken.antifraudspringboot.entity.Result;

import java.util.List;
import java.util.Map;

public interface ChartsService {
    List<Map<String, Object>> getWeekCountArticle();

    List<Map<String, Object>> getMostTag();
}
