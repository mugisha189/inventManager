package com.example.inventManager.services.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.inventManager.dto.requests.CreateItemDTO;
import com.example.inventManager.models.Item;
import com.example.inventManager.payload.ApiResponse;
import com.example.inventManager.repositories.ItemRepository;
import com.example.inventManager.services.ItemService;
import com.example.inventManager.utils.Hash;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public ResponseEntity<ApiResponse> getItemById(UUID itemId) {
        try {
            Optional<Item> item = itemRepository.findById(itemId);
            if (item == null)
                throw new BadRequestException("The item with the provided id is not found");
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse(true, "The item retrieved successfully", item));
        } catch (BadRequestException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(false, exception.getMessage()));
        }
    }

    @Override
    public ResponseEntity<ApiResponse> createItem(CreateItemDTO createItemDTO) {
        Item item = new Item(createItemDTO.getName(), createItemDTO.getQuantity(), createItemDTO.getPrice());
        return ResponseEntity.ok().body(new ApiResponse(
                true,
                "Successfully created item",
                item));
    }

    @Override
    public void deleteItem(UUID itemId) {
        itemRepository.deleteById(itemId);
    }
}