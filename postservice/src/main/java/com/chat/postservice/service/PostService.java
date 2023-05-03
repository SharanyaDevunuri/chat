package com.chat.postservice.service;

import com.chat.postservice.entity.Post;
import com.chat.postservice.exception.ResourceNotFoundException;
import com.chat.postservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    
    public List<Post> getPostsByUserId(int userId) {
        return postRepository.getPostsByUserId(userId);
    }
    
    public Post createPost(Post post) {
        post.setCreatedAt(new Date());
        return postRepository.save(post);
    }
    
    public Post updatePost(Long postId, Post post) throws ResourceNotFoundException {
        Post existingPost = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        existingPost.setTitle(post.getTitle());
        existingPost.setContent(post.getContent());
        return postRepository.save(existingPost);
    }
    
    public void deletePost(Long postId) throws ResourceNotFoundException {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        postRepository.delete(post);
    }
}
