package com.yb.onlineexamserver.config.securityconfig;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @Auther: Yang
 * @Date: 2020/04/11 16:08
 * @Description:
 */
@Component
public class MyUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //通过用户名获取用户信息
        //封装为一个UserDetails对象，User是UserDeatils的一个实现类
        //模拟从数据库查询出来的密码和角色
        String password = "123456";
        User user = new User(username,password, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_STUDENT"));
        return user;
    }
}