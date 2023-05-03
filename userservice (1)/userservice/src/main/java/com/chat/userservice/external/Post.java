package com.chat.userservice.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private Long id;
    

    private String title;
    
    private String content;
    
    private Date createdAt;

    private Long userId;

    // getters and setters
}
