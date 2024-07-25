package com.awaken.antifraudspringboot.mapper;

import java.util.List;
import java.util.Map;

public interface QuestionDao {
    List<Map<String, Object>> findByPage(Map<String, Object> params);

    long count();
}
