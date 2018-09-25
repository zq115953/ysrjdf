package com.nectar.myblog.service.impl;

import com.nectar.myblog.mapper.CategoryMapper;
import com.nectar.myblog.service.ArticleService;
import com.nectar.myblog.service.CategoryService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServicImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    ArticleService articleService;

    @Override
    public JSONObject findCategoriesNameAndArticleNum() {
        List<String> categoryNames = categoryMapper.findCategoriesName();
        JSONObject categoryJson;
        JSONArray categoryJsonArray = new JSONArray();
        JSONObject reurnJson = new JSONObject();
        for (String categoryName : categoryNames){
            categoryJson = new JSONObject();
            categoryJson.put("categoryName", categoryName);
            categoryJson.put("categoryArticleNum", articleService.countArticleCategoryByCategory(categoryName));
            categoryJsonArray.add(categoryJson);
        }
        reurnJson.put("status",200);
        reurnJson.put("result", categoryJsonArray);
        System.out.println("findCategories info is" + reurnJson);
        return reurnJson;
    }

    @Override
    public JSONArray findCategoriesName() {
        List<String> categoryNames = categoryMapper.findCategoriesName();
        return JSONArray.fromObject(categoryNames);
    }

    @Override
    public int countCategoriesNum() {
        return categoryMapper.countCategoriesNum();
    }
}
