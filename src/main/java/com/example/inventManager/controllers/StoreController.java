package com.example.inventManager.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.inventManager.dto.requests.CreateStoreDTO;
import com.example.inventManager.models.Store;
import com.example.inventManager.payload.ApiResponse;
import com.example.inventManager.services.StoreService;
import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/stores")
public class StoreController {
    private StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllStores() {
        List<Store> stores = this.storeService.getAllStores();
        return ResponseEntity.ok().body(new ApiResponse(
                true,
                "Successfully retrieved stores",
                stores));
    }

    @GetMapping("/{storeId}")
    public ResponseEntity<ApiResponse> getStoreById(@PathVariable UUID storeId) {
        return this.storeService.getStoreById(storeId);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createStore(@RequestBody CreateStoreDTO store) {
        return this.storeService.createStore(store);
    }

    @DeleteMapping("/{storeId}")
    public ResponseEntity<Void> deleteStore(@PathVariable UUID storeId) {
        this.storeService.deleteStore(storeId);
        return ResponseEntity.noContent().build();
    }
}
