package com.example.login_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.login_demo.dto.LoginRequest;
import com.example.login_demo.dto.LoginResponse;
import com.example.login_demo.service.UserService;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request, HttpSession session) {
        LoginResponse response = userService.login(request.getUsername(), request.getPassword());
        if (response != null) {
            session.setAttribute("loggedInUser", response);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body("用户名或密码错误");
        }
    }

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(HttpSession session) {
        return ResponseEntity.status(401).body("未登录");
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate(); // 清除 session
        return ResponseEntity.ok("已退出登录");
    }

}
