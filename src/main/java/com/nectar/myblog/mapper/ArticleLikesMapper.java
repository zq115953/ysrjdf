package com.nectar.myblog.mapper;

import com.nectar.myblog.entity.ArticleLikesRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 */
@Mapper
@Repository
public interface ArticleLikesMapper {

    @Insert("insert into article_likes_record(articleId,originalAuthor,likerId,likeDate) values(#{articleId},#{originalAuthor},#{likerId},#{likeDate})")
    void insertArticleLikesRecord(ArticleLikesRecord articleLikesRecord);

    @Select("select likeDate from article_likes_record where articleId=#{articleId} and originalAuthor=#{originalAuthor} and likerId=#{likerId}")
    ArticleLikesRecord isLiked(@Param("articleId") long articleId, @Param("originalAuthor") String originalAuthor, @Param("likerId") int likerId);


}
