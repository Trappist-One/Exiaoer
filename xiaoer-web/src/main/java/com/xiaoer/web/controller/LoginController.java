package com.xiaoer.web.controller;

import com.xiaoer.common.result.Result;
import com.xiaoer.pojo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public Result login(User user) {
        if ("admin".equals(user.getName()) && "123456".equals(user.getPassword())) {
            return Result.createSuccess();
        } else {
            return Result.createError("用户或密码错误！");
        }
    }
}
