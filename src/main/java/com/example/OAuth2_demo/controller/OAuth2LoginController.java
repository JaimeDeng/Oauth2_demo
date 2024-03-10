package com.example.OAuth2_demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuth2LoginController {

    @GetMapping("/user")
    public String getUserInfo(Authentication authentication) {
        if (authentication instanceof OAuth2AuthenticationToken) {
            OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;

            // 獲取用戶訊息
            String username = oauthToken.getName();
            OAuth2User user = oauthToken.getPrincipal();
            String name = user.getAttribute("name");

            return "Authenticated user: " + name;
        } else {
            return "Not authenticated!";
        }
    }
}