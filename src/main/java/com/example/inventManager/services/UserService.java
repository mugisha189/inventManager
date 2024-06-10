package com.example.inventManager.services;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.example.inventManager.dto.requests.CreateUserDTO;
import com.example.inventManager.models.User;
import com.example.inventManager.payload.ApiResponse;

public interface UserService {
    public List<User> getAllUsers();

    ResponseEntity<ApiResponse> getUserById(UUID id);

    ResponseEntity<ApiResponse> createUser(CreateUserDTO user);

    public void deleteUser(UUID id);
}
