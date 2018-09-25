package com.nectar.myblog.service.impl;

import com.nectar.myblog.mapper.VisitorMapper;
import com.nectar.myblog.service.VisitorService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class VistorServiceImpl implements VisitorService {
    @Autowired
    VisitorMapper visitorMapper;

    @Override
    public void addVisitorNumByPageName(String pageName, HttpServletRequest request) {
        String visitor;
        if("visitorVolume".equals(pageName)){
            visitor = (String) request.getSession().getAttribute("visitor");
            if (visitor == null){
            request.getSession().setAttribute("visitor", "yes");
            }else {
                visitorMapper.updateVisitorNumByTotalVisitor();
            }
        }else {
            visitor = (String) request.getSession().getAttribute(pageName);
            if(visitor == null){
                visitorMapper.updateVisitorNumByTotalVisitorAndPageName(pageName);
                request.getSession().setAttribute(pageName, "yes");
            }else {
                visitorMapper.updateVisitorNumByTotalVisitor();
            }
        }

    }

    @Override
    public JSONObject getVisitorNumByPageName(String pageName) {
        long totalVisitor = visitorMapper.getVisitorNumByPageName("totalVisitor");
        long pagerVIsitor = visitorMapper.getVisitorNumByPageName(pageName);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("totalVisitor", totalVisitor);
        jsonObject.put("pageVisitor", pagerVIsitor);
        return jsonObject;
    }

    @Override
    public long getNumByPageName(String pageName) {
        return visitorMapper.getVisitorNumByPageName(pageName);
    }

    @Override
    public void insertVisitorArticlePage(String pageName) {
        visitorMapper.insertVisitorArticlePage(pageName);
    }

    @Override
    public long getAllVisitor() {
        return visitorMapper.getAllVisitor();
    }
}
