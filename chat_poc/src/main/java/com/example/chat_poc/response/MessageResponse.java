package com.example.chat_poc.response;

import lombok.Data;

@Data
public class MessageResponse {
    private String message;
    public MessageResponse(String message) {
        this.message = message;
    }
}
