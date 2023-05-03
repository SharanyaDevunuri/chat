package com.chat.chatservice.repositories;

import com.chat.chatservice.model.ChatModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<ChatModel, Long> {
}
