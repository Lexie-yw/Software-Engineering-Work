package com.work.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
@Data
public class User {
    @Id
    private String userId;
    private String userName;
    private String email;
    private String password;
}
