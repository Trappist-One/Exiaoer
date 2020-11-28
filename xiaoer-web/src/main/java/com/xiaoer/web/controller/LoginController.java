package com.xiaoer.web.controller;

import com.xiaoer.common.result.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public Result login() {
        return Result.createSuccess();
    }
}
