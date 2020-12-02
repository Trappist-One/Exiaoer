package com.xiaoer.oauth.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: mcr
 * @Date: 2020/12/2 17:25
 */
@Slf4j
@Component
public class XiaoerUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    // loadUserByUsername方法，它要接收一个字符串参数，也就是传过来的用户名，返回一个 UserDetails对象
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.info("usernameis:" + username);
        // 查询数据库操作
        if(!username.equals("admin")){
            throw new UsernameNotFoundException("the user is not found");
        }else{
            // 用户角色也应在数据库中获取
            String role = "ROLE_ADMIN";
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(role));
            // 线上环境应该通过用户名查询数据库获取加密后的密码
            String password = passwordEncoder.encode("123456");
            return new org.springframework.security.core.userdetails.User(username,password, authorities);
        }
    }

}
