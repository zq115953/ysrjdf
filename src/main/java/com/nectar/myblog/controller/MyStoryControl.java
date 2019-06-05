package com.nectar.myblog.controller;

import com.nectar.myblog.service.ArticleService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Describe:
 */
@RestController
public class MyStoryControl {

    @Autowired
    ArticleService articleService;

    @GetMapping("/getMyStory")
    public JSONObject getMyStory(@RequestParam("rows") String rows,
                                 @RequestParam("pageNum") String pageNum){
        return articleService.findArticleByCategory("我的故事",Integer.parseInt(rows), Integer.parseInt(pageNum));
    }

}
