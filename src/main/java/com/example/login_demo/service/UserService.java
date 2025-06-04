package com.example.login_demo.service;

import org.springframework.stereotype.Service;

import com.example.login_demo.entity.User;
import com.example.login_demo.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    // 构造器注入 UserRepository
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 登录验证
    public boolean login(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        return user != null;
    }
}
