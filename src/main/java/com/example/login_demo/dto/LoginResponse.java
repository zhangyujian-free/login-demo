package com.example.login_demo.dto;

public class LoginResponse {
    private Long id;
    private String username;
    private String message;

    // 空构造器
    public LoginResponse() {
    }

    // 全参构造器
    public LoginResponse(Long id, String username, String message) {
        this.id = id;
        this.username = username;
        this.message = message;
    }

    // Getter 和 Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
