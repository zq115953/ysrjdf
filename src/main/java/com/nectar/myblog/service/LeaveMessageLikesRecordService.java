package com.nectar.myblog.service;

import com.nectar.myblog.entity.LeaveMessageLikesRecord;

public interface LeaveMessageLikesRecordService {
   /**
           * 是否点赞
     * @param pageName 文章页
     * @param pId 父id
     * @param likeId 当前用户id
     * @return true -- 已经点过赞  false -- 还没有点过赞
     */
    boolean isLiked(String pageName, int pId, int likeId);

    /**
     * 保存点赞记录
     * @param leaveMessageLikesRecord
     */
    void insertLeaveMessageLikesRecord(LeaveMessageLikesRecord leaveMessageLikesRecord);
}
