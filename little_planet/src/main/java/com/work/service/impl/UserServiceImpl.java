package com.work.service.impl;

import com.work.dao.UserRepository;
import com.work.entity.User;
import com.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User login(String email, String password) {
        ExampleMatcher matcher=ExampleMatcher
                .matching()
                .withMatcher("email",ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("password",ExampleMatcher.GenericPropertyMatchers.contains());
        User user=new User();
        user.setEmail(email);
        user.setPassword(password);
        Example<User> example=Example.of(user,matcher);
        User loginUser=userRepository.findOne(example).orElse(null);

        return loginUser;
    }

    @Override
    public User getUserByUserId(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User getUserByEamil(String email) {
        ExampleMatcher matcher=ExampleMatcher
                .matching()
                .withMatcher("email",ExampleMatcher.GenericPropertyMatchers.contains());

        User user=new User();
        user.setEmail(email);
        Example<User> example=Example.of(user,matcher);
        return userRepository.findOne(example).orElse(null);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void delUser(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }
}
