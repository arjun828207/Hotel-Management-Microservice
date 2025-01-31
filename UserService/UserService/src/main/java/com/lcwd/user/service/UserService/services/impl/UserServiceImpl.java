package com.lcwd.user.service.UserService.services.impl;

import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.exception.ResourceNotFoundException;
import com.lcwd.user.service.UserService.respositories.UserRepository;
import com.lcwd.user.service.UserService.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {

        String randUserId = UUID.randomUUID().toString();
        user.setUserId(randUserId);
        return userRepository.save(user);
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with ID " + userId + " not found on server"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(String userId, User user) {
        return null;
    }

    @Override
    public boolean deleteUser(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User with ID " + userId + " not found"));
        userRepository.delete(user);

        return true;
    }
}
