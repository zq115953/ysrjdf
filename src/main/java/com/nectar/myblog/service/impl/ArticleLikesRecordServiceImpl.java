package com.nectar.myblog.service.impl;

import com.nectar.myblog.entity.ArticleLikesRecord;
import com.nectar.myblog.mapper.ArticleLikesMapper;
import com.nectar.myblog.service.ArticleLikesRecordService;
import com.nectar.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleLikesRecordServiceImpl implements ArticleLikesRecordService {
    @Autowired
    ArticleLikesMapper articleLikesMapper;
    @Autowired
    UserService userService;

    @Override
    public boolean isLiked(long articleId, String originalAuthor, String username) {
        ArticleLikesRecord articleLikesRecord = articleLikesMapper.isLiked(articleId, originalAuthor, userService.findIdByUsername(username));

        return articleLikesRecord != null;
    }

    @Override
    public void insertArticleLikesRecord(ArticleLikesRecord articleLikesRecord) {
        articleLikesMapper.insertArticleLikesRecord(articleLikesRecord);
    }
}
