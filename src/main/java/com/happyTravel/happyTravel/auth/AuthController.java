package com.happyTravel.happyTravel.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @PostMapping(value="login")
    public String login(){
        return "login from public endpoint";
    }

    @PostMapping(value="register")
    public String register(){
        return "register from public endpoint";
    }
}
