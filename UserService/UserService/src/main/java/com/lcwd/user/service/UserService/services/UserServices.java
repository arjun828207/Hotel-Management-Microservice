package com.lcwd.user.service.UserService.services;

import com.lcwd.user.service.UserService.entities.User;

import java.util.List;

public interface UserServices {

    User saveUser(User user);

    User getUser(String userId);

    List<User> getAllUsers();

    User updateUser(String userId, User user);

    boolean deleteUser(String userId);

}
