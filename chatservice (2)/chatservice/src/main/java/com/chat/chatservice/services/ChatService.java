package com.chat.chatservice.services;

import com.chat.chatservice.model.ChatModel;
import com.chat.chatservice.repositories.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;

    public List<ChatModel> getAllMessages() {
        return chatRepository.findAll();
    }

    public ChatModel getMessageById(Long id) throws Exception {
        return chatRepository.findById(id)
                .orElseThrow(() -> new Exception("Message not found with id " + id));
    }

    public ChatModel createMessage(ChatModel message) {
        return chatRepository.save(message);
    }

    public ChatModel updateMessage(Long id, ChatModel messageDetails) throws Exception {
        ChatModel message = chatRepository.findById(id)
                .orElseThrow(() -> new Exception("Message not found with id " + id));

        message.setMsg(messageDetails.getMsg());
        message.setEmail(messageDetails.getEmail());
        message.setName(messageDetails.getName());

        return chatRepository.save(message);
    }

    public ResponseEntity<?> deleteMessage(Long id) throws Exception {
        ChatModel message = chatRepository.findById(id)
                .orElseThrow(() -> new Exception("Message not found with id " + id));

        chatRepository.delete(message);

        return ResponseEntity.ok().build();
    }
}
