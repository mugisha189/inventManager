package com.example.inventManager.services;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.example.inventManager.dto.requests.CreateItemDTO;
import com.example.inventManager.models.Item;
import com.example.inventManager.payload.ApiResponse;

public interface ItemService {
    public List<Item> getAllItems();

    ResponseEntity<ApiResponse> getItemById(UUID id);

    ResponseEntity<ApiResponse> createItem(CreateItemDTO item);

    public void deleteItem(UUID id);
}
