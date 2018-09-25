package com.nectar.myblog.service.impl;

import com.nectar.myblog.entity.LeaveMessageLikesRecord;
import com.nectar.myblog.mapper.LeaveMessageLikesRecordMapper;
import com.nectar.myblog.service.LeaveMessageLikesRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveMessageLikesRecordServiceImpl implements LeaveMessageLikesRecordService {
    @Autowired
    LeaveMessageLikesRecordMapper leaveMessageLikesRecordMapper;

    @Override
    public boolean isLiked(String pageName, int pId, int likeId) {
        return leaveMessageLikesRecordMapper.isLiked(pageName, pId, likeId) !=null;
    }

    @Override
    public void insertLeaveMessageLikesRecord(LeaveMessageLikesRecord leaveMessageLikesRecord) {
        leaveMessageLikesRecordMapper.insertLeaveMessageLikesRecord(leaveMessageLikesRecord);
    }
}
