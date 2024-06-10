package com.example.inventManager.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.inventManager.dto.requests.CreateItemDTO;
import com.example.inventManager.models.Item;
import com.example.inventManager.payload.ApiResponse;
import com.example.inventManager.services.ItemService;
import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllItems() {
        List<Item> items = this.itemService.getAllItems();
        return ResponseEntity.ok().body(new ApiResponse(
                true,
                "Successfully retrieved items",
                items));
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<ApiResponse> getItemById(@PathVariable UUID itemId) {
        return this.itemService.getItemById(itemId);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createItem(@RequestBody CreateItemDTO item) {
        return this.itemService.createItem(item);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable UUID itemId) {
        this.itemService.deleteItem(itemId);
        return ResponseEntity.noContent().build();
    }
}
