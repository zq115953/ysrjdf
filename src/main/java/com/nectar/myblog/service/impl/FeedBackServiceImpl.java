package com.nectar.myblog.service.impl;

import com.nectar.myblog.entity.FeedBack;
import com.nectar.myblog.mapper.FeedBackMapper;
import com.nectar.myblog.service.FeedBackService;
import com.nectar.myblog.service.UserService;
import com.nectar.myblog.utils.TimeUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedBackServiceImpl implements FeedBackService {
    @Autowired
    FeedBackMapper feedBackMapper;
    @Autowired
    UserService userService;


    @Override
    public JSONObject submitFeedback(FeedBack feedBack) {
        TimeUtil timeUtil = new TimeUtil();
        feedBack.setFeedbackDate(timeUtil.getFormatDateForSix());
        feedBackMapper.insertFeedback(feedBack);
        JSONObject returnJson = new JSONObject();
        returnJson.put("status", 200);
        return returnJson;
    }

    @Override
    public JSONObject getAllFeedback(int rows, int pageNum) {
        return null;
    }
}
