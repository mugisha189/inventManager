package com.example.inventManager.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.inventManager.dto.requests.CreateUserDTO;
import com.example.inventManager.models.User;
import com.example.inventManager.payload.ApiResponse;
import com.example.inventManager.services.UserService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllUsers() {
        List<User> users = this.userService.getAllUsers();
        return ResponseEntity.ok().body(new ApiResponse(
                true,
                "Successfully retrieved users",
                users));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable UUID userId) {
        return this.userService.getUserById(userId);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createUser(@RequestBody CreateUserDTO user) {
        return this.userService.createUser(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID userId) {
        this.userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
