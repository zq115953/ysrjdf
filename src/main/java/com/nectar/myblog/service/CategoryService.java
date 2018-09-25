package com.nectar.myblog.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 分类业务操作
 */
public interface CategoryService {
    /**
     * 获得所有分类及分类的文章总数
     * @return
     */
    JSONObject findCategoriesNameAndArticleNum();

    /**
     * 获取所有的分类
     * @return
     */
    JSONArray findCategoriesName();

    /**
     * 获得分类数目
     * @return
     */
    int countCategoriesNum();

}
