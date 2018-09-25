package com.nectar.myblog.service;

import net.sf.json.JSONObject;

/**
 * 标签业务
 */
public interface TagService {
    /**
     * 加入标签
     * @param tags
     * @param tagSize
     */
    void addTags(String[] tags, int tagSize);

    /**
     * 获得标签
     * @return
     */
    JSONObject findTagsCloud();

    /**
     * 获得标签数量
     * @return
     */
    int countTagsNum();

    /**
     * 通过标签名得到标签大小
     * @param tagName
     * @return
     */
    int getTagsSizeByTagName(String tagName);
}
