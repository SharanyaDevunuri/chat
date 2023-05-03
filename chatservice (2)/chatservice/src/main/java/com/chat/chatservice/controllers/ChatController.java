package com.chat.chatservice.controllers;

import com.chat.chatservice.services.ChatService;
import com.chat.chatservice.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9093")
@RequestMapping("/api/messages")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @GetMapping
    public List<ChatModel> getAllMessages() {
        return chatService.getAllMessages();
    }

    @GetMapping("/{id}")
    public ChatModel getMessageById(@PathVariable Long id) throws Exception {
        return chatService.getMessageById(id);
    }

    @PostMapping
    public ChatModel createMessage(@RequestBody ChatModel message) {
        return chatService.createMessage(message);
    }

    @PutMapping("/{id}")
    public ChatModel updateMessage(@PathVariable Long id, @RequestBody ChatModel messageDetails) throws Exception {
        return chatService.updateMessage(id, messageDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable Long id) throws Exception {
        return chatService.deleteMessage(id);
    }
}
