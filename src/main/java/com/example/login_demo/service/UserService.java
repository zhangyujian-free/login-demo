package com.example.login_demo.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.login_demo.dto.LoginResponse;
import com.example.login_demo.dto.UserDTO;
import com.example.login_demo.entity.User;
import com.example.login_demo.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    // 构造器注入 UserRepository ModelMapper
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    // 登录验证
    public LoginResponse login(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user != null) {
            UserDTO userDTO = modelMapper.map(user,UserDTO.class);
            return new LoginResponse(userDTO.getId(), userDTO.getUsername(), "登录成功！欢迎您。");
        } else {
            return null;
        }
    }
}
