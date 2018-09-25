package com.nectar.myblog.controller.register;

import com.nectar.myblog.entity.Password;
import com.nectar.myblog.entity.User;
import com.nectar.myblog.service.UserService;
import com.nectar.myblog.utils.MD5Util;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class RegisterController {
    @Resource
    UserService userService;

    @PostMapping("/register")
    public String register(User user, HttpServletRequest request){
        String authCode = request.getParameter("authCode");

        String trueMsgCode = (String) request.getSession().getAttribute("trueMsgCode");

        //检测手机验证码
        if(!authCode.equals(trueMsgCode)){
            return "0";
        }
        if(userService.usernameIsExit(user.getUsername())){
            return "3";
        }
        Password password = new Password();
        password.setPassword(user.getPassword());
        password.setUsername(user.getUsername());
        //注册时对密码进行MD5加密
        MD5Util md5Util = new MD5Util();
        user.setPassword(md5Util.encode(user.getPassword()));
        return userService.insert(user);
    }

}
