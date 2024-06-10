package com.example.inventManager.services;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.example.inventManager.dto.requests.CreateStoreDTO;
import com.example.inventManager.models.Store;
import com.example.inventManager.payload.ApiResponse;

public interface StoreService {
    public List<Store> getAllStores();

    ResponseEntity<ApiResponse> getStoreById(UUID id);

    ResponseEntity<ApiResponse> createStore(CreateStoreDTO store);

    public void deleteStore(UUID id);
}
