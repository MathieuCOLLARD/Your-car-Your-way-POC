package com.example.chat_poc.repository;

import com.example.chat_poc.entity.MessageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<MessageEntity, Long> {
    List<MessageEntity> findAllByOrderByTimestampAsc();
}
