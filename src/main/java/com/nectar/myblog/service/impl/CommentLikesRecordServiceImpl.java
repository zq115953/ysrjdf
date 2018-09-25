package com.nectar.myblog.service.impl;

import com.nectar.myblog.entity.CommentLikesRecord;
import com.nectar.myblog.mapper.CommentLikesMapper;
import com.nectar.myblog.service.CommentLikesRecordService;
import com.nectar.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentLikesRecordServiceImpl implements CommentLikesRecordService {
    @Autowired
    CommentLikesMapper commentLikesMapper;
    @Autowired
    UserService userService;

    @Override
    public boolean isLiked(long articleId, String originalAuthor, long pId, String username) {
        return commentLikesMapper.isLiked(articleId, originalAuthor, pId, userService.findIdByUsername(username)) != null;
    }

    @Override
    public void insertCommentLikesRecord(CommentLikesRecord commentLikesRecord) {
        commentLikesMapper.insertCommentLikesRecord(commentLikesRecord);
    }
}
