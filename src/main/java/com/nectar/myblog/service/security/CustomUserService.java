package com.nectar.myblog.service.security;

import com.nectar.myblog.entity.Role;
import com.nectar.myblog.entity.User;
import com.nectar.myblog.mapper.UserMapper;
import com.nectar.myblog.service.UserService;
import com.nectar.myblog.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Describe: 用户登录处理
 */
@Component
public class CustomUserService implements UserDetailsService{


    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException{


        User user = userMapper.getUsernameAndRolesByPhone(phone);

        if(user == null){
            return (UserDetails) new UsernameNotFoundException("用户不存在");
        }

        TimeUtil timeUtil = new TimeUtil();
        String recentlyLanded = timeUtil.getFormatDateForSix();
        userService.updateRecentlyLanded(user.getUsername(), recentlyLanded);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for(Role role : user.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        System.out.println(phone + "用户登录成功");
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
