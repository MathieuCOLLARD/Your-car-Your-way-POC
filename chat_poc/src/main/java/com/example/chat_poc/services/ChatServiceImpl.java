package com.example.chat_poc.services;

import com.example.chat_poc.dto.MessageDTO;
import com.example.chat_poc.entity.MessageEntity;
import com.example.chat_poc.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChatServiceImpl implements ChatService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String sendMessage(MessageDTO messageDTO) {
        // Convert MessageDTO to MessageEntity using ModelMapper
        MessageEntity messageEntity = modelMapper.map(messageDTO, MessageEntity.class);

        messageEntity.setTimestamp(System.currentTimeMillis());
        // Save the MessageEntity to the repository
        messageRepository.save(messageEntity);

        return "Message sent!";
    }

    @Override
    public List<MessageDTO> getAllMessages() {
        // Retrieve all messages from the repository
        List<MessageEntity> messages = messageRepository.findAllByOrderByTimestampAsc();

        // Convert the list of MessageEntity objects to MessageDTO using ModelMapper
        return messages.stream()
                .map(message -> modelMapper.map(message, MessageDTO.class))
                .collect(Collectors.toList());
    }
}

