package com.nectar.myblog.service;

import com.nectar.myblog.entity.ArticleLikesRecord;

/**
 * 点赞业务
 */
public interface ArticleLikesRecordService {
    /**
     * 文章是否有人点赞
     * @param articleId
     * @param originalAuthor
     * @param username
     * @return
     */
    boolean isLiked(long articleId, String originalAuthor, String username);

    /**
     * 保存文章点赞的记录
     * @param articleLikesRecord
     */
    void insertArticleLikesRecord(ArticleLikesRecord articleLikesRecord);
}
