package com.work.service;

import com.work.entity.User;


public interface UserService {
    User login(String email,String password);
    User getUserByUserId(String userId);
    User getUserByEamil(String email);
    void addUser(User user);
    void delUser(String userId);
    void updateUser(User user);
}
