package com.niu.sso.clienta.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 *
 * @author [nza]
 * @version 1.0 2020/10/18
 * @createTime 11:17
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public Authentication user(Authentication user) {
        return user;
    }
}
