package com.nectar.myblog.controller;

import com.nectar.myblog.service.ArchiveService;
import com.nectar.myblog.service.ArticleService;
import com.nectar.myblog.utils.TransCodingUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 归档
 */
@RestController
public class ArchivesControl {
    @Autowired
    ArchiveService archiveService;
    @Autowired
    ArticleService articleService;
    /**
     * 获得所有归档日期以及每个归档日期的文章数目
     * @return
     */
    @GetMapping("/findArchiveNameAndArticleNum")
    public JSONObject findArchiveNameAndArticleNum(){
        return archiveService.findArchiveNameAndArticleNum();
    }
    @GetMapping("/getArchiveArticle")
    public JSONObject getArchiveArticle(@RequestParam("archive") String archive,
                                        HttpServletRequest request){
        try {
            archive = TransCodingUtil.unicodeToString(archive);
        }catch (Exception e){
        }
        int rows = Integer.parseInt(request.getParameter("rows") );
        int pageNum = Integer.parseInt(request.getParameter("pageNum") );
        return articleService.findArticleByArchive(archive, rows, pageNum);
    }
}