package com.example.chat_poc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "MESSAGES")
@NoArgsConstructor
@AllArgsConstructor
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sender")
    private String sender;

    @Column(name = "content")
    private String content;

    @Column(name = "timestamp")
    private Long timestamp;

}
