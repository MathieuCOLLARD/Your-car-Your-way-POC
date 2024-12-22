package com.example.chat_poc.controllers;

import com.example.chat_poc.dto.MessageDTO;
import com.example.chat_poc.response.MessageResponse;
import com.example.chat_poc.services.ChatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/send")
    public MessageResponse sendMessage(@RequestBody MessageDTO messageDTO) {
        System.out.println("MessageDTO: " + messageDTO);
        return new MessageResponse(chatService.sendMessage(messageDTO));
    }

    @GetMapping("/history")
    public ResponseEntity<List<MessageDTO>> getAllMessages() {
        List<MessageDTO> history = chatService.getAllMessages();
        return ResponseEntity.ok(history);
    }
}

