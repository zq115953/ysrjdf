package com.nectar.myblog.controller.errorpage;
/**
 * 错误页面的跳转
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorPageController {
    @GetMapping("/404")
    public String error404(HttpServletRequest request,
                           Model model){
        String username = (String) request.getSession().getAttribute("username");
        model.addAttribute("username",username);
        return "404";
    }

    @GetMapping("/403")
    public String error403(HttpServletRequest request,
                           Model model){
        String username = (String) request.getSession().getAttribute("username");
        model.addAttribute("username",username);
        return "403";
    }
}
