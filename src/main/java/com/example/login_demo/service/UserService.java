package com.example.login_demo.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.login_demo.dto.LoginResponse;
import com.example.login_demo.dto.UserDTO;
import com.example.login_demo.entity.User;
import com.example.login_demo.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    // 构造器注入 UserRepository ModelMapper PasswordEncoder
    public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    // 登录验证
    public LoginResponse login(String username, String rawpassword) {
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(rawpassword, user.getPassword())) {
            UserDTO userDTO = modelMapper.map(user, UserDTO.class);
            return new LoginResponse(userDTO.getId(), userDTO.getUsername(), "登录成功！欢迎您。");
        } else {
            return null;
        }
    }

    // 注册
    public boolean register(String username, String rawPassword) {
        if (userRepository.findByUsername(username) != null)
            return false;
        String hashedPassword = passwordEncoder.encode(rawPassword);
        User user = new User();
        user.setUsername(username);
        user.setPassword(hashedPassword);
        userRepository.save(user);

        return true;
    }
}
