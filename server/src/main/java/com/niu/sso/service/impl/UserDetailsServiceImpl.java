package com.niu.sso.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * UserDetails 实现类
 *
 * @author [nza]
 * @version 1.0 2020/10/18
 * @createTime 11:59
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return new User(username,
                passwordEncoder.encode("123456"),
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER,ROLE_TOURIST"));
    }
}
