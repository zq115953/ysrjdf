package com.nectar.myblog.service;

import com.nectar.myblog.entity.FeedBack;
import net.sf.json.JSONObject;
import org.springframework.transaction.annotation.Transactional;

/**
 * 反馈信息
 */
public interface FeedBackService {
    /**
     * 保存反馈信息
     * @param feedBack
     * @return
     */
    @Transactional
    JSONObject submitFeedback(FeedBack feedBack);

    /**
     * 获得所有的反馈
     * @return
     */
    JSONObject getAllFeedback(int rows, int pageNum);
}
