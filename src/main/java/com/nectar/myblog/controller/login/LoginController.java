package com.nectar.myblog.controller.login;

import com.nectar.myblog.entity.User;
import com.nectar.myblog.service.UserService;
import com.nectar.myblog.utils.MD5Util;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 登陆控制
 */
@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @ResponseBody
    @PostMapping("/changePassword")
    public String changePassword(@RequestParam("phone") String phone,
                                 @RequestParam("authCode") String authCode,
                                 @RequestParam("newPassword") String newPassword,
                                 HttpServletRequest request){
            String trueMsgCode = (String) request.getSession().getAttribute("trueMsgCode");
            if(!authCode.equals(trueMsgCode)){
                return "0";
            }
        User user = userService.findUserByPhone(phone);
            if(user == null){
                return "2";
            }
            MD5Util md5Util = new MD5Util();
            String MD5Password = md5Util.encode(newPassword);
            userService.updatePasswordByPhone(phone, MD5Password);
            return "1";
    }
    @Secured({"ROLE_USER"})
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(){
           return "index";
    }

}
