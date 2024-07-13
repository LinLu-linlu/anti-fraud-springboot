package com.awaken.antifraudspringboot.controller;

import com.awaken.antifraudspringboot.entity.Result;
import com.awaken.antifraudspringboot.service.ChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/charts")
public class ChartsController {
    @Autowired
    private ChartsService chartsService;

    @GetMapping("/week_count_article")
    public Result getWeekCountArticle() {
        Map<String, Object> data = new HashMap<>();
        try{
            List<Map<String,Object>> weekCount = chartsService.getWeekCountArticle();
            data.put("weekCount", weekCount);
            List<String> name = new ArrayList<>();
            data.put("name", name);
            List<String> value = new ArrayList<>();
            data.put("value", value);
            if (!weekCount.isEmpty()) {
                for (Map<String, Object> map : weekCount) {
                    name.add(map.get("name").toString());
                    value.add(map.get("value").toString());
                }
            }
            return new Result(true, "成功", data);
        }catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"失败");
        }
    }

    @GetMapping("/most_tag")
    public Result getMostTag() {
        Map<String, Object> data = new HashMap<>();
        try{
            List<Map<String,Object>> mostTags = chartsService.getMostTag();
            data.put("mostTags", mostTags);
            List<String> name = new ArrayList<>();
            data.put("name", name);
            List<String> value = new ArrayList<>();
            data.put("value", value);
            if (!mostTags.isEmpty()) {
                for (Map<String, Object> map : mostTags) {
                    name.add(map.get("name").toString());
                    value.add(map.get("value").toString());
                }
            }
            return new Result(true, "成功", data);
        }catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"失败");
        }
    }
}
