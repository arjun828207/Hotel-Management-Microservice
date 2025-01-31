package com.lcwd.user.service.controllers;


import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId)
    {
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);

    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User user) {
        try {
            User updatedUser = userService.updateUser(userId, user);

            if (updatedUser != null) {
                return new ResponseEntity<>(updatedUser, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{userId}")  // or your specific path
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        try {
            boolean deleted = userService.deleteUser(userId);

            if (deleted) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // 204 is standard for successful deletion
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);   // 404 if user not found
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
