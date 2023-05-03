package com.chat.postservice.controller;

import com.chat.postservice.entity.Post;
import com.chat.postservice.exception.ResourceNotFoundException;
import com.chat.postservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;
    
    @GetMapping("/")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
    
    @GetMapping("/user/{userId}")
    public List<Post> getPostsByUserId(@PathVariable int userId) {
        return postService.getPostsByUserId(userId);
    }
    
    @PostMapping("/")
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }
    
    @PutMapping("/{postId}")
    public Post updatePost(@PathVariable(value = "postId") Long postId, 
                           @RequestBody Post post) {
        try {
            return postService.updatePost(postId, post);
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable(value = "postId") Long postId) {
        try {
            postService.deletePost(postId);
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().build();
    }
}
