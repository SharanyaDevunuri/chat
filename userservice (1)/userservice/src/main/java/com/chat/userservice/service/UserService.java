package com.chat.userservice.service;

import com.chat.userservice.Entity.User;
import com.chat.userservice.external.Post;
import com.chat.userservice.external.PostService;
import com.chat.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostService postService;
    public String saveUser(User user) {
        //check if user is present or not already
//        User existingUser=getUserById(user.getId());
//        if(existingUser!=null){
//            throw new RuntimeException("User present already in DB");
//        }
        userRepository.save(user);

        return "User added Successfully";
    }

    public List<User> findAll() {
        List<User> users = userRepository.findAll();

       for(User user: users){
           List<Post> posts =postService.getPostsByUserId(user.getId());
           user.setPosts(posts);
       }
        return users;
    }

    public User getUserById(int userId) {
       User user= userRepository.findById(userId).get();

        List<Post> posts =postService.getPostsByUserId(userId);
        user.setPosts(posts);
        return user;

    }

    public User updateUser(User user) {
        User existingUser=getUserById(user.getId());
        if(existingUser!=null){
            existingUser.setFirstname(user.getFirstname());
            existingUser.setLastname(user.getLastname());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setGender(user.getGender());
            existingUser.setContact(user.getContact());
            return userRepository.save(existingUser);
        }
        return null;

    }

    public String deleteUser(int id) {
    userRepository.delete(getUserById(id));
        return "User deleted successfully";
    }
}
