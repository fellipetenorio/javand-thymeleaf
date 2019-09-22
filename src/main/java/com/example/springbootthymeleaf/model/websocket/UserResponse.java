package com.example.springbootthymeleaf.model.websocket;

public class UserResponse {
    public String content;

    public UserResponse() {
    }

    public UserResponse(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
