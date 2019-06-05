package com.nectar.myblog.mapper;

import com.nectar.myblog.entity.CommentLikesRecord;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * Describe: 评论点赞sql
 */
@Mapper
@Repository
public interface CommentLikesMapper {

    @Insert("insert into comment_likes_record(articleId,pId,likerId,likeDate) values(#{articleId},#{pId},#{likerId},#{likeDate})")
    void insertCommentLikesRecord(CommentLikesRecord commentLikesRecord);

    @Select("select likeDate from comment_likes_record where articleId=#{articleId} and pId=#{pId} and likerId=#{likerId}")
    CommentLikesRecord isLiked(@Param("articleId") long articleId, @Param("pId") long pId, @Param("likerId") int likerId);

    @Delete("delete from comment_likes_record where articleId=#{articleId}")
    void deleteCommentLikesRecordByArticleId(long articleId);
}
