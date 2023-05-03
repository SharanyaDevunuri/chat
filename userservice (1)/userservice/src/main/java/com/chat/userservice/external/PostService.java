package com.chat.userservice.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "POST-SERVICE")
public interface PostService {

    @GetMapping("/api/posts/user/{userId}")
    List<Post> getPostsByUserId(@PathVariable int userId) ;

}
