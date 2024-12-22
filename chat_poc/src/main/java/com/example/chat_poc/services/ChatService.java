package com.example.chat_poc.services;

import com.example.chat_poc.dto.MessageDTO;

import java.util.List;

public interface ChatService {
    /**
     * @param messageDTO
     * @return MessageDTO
     */
    String sendMessage(MessageDTO messageDTO);

    /**
     * @return List<MessageDTO>
     */
    List<MessageDTO> getAllMessages();
}
