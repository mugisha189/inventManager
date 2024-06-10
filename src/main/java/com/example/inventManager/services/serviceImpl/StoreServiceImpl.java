package com.example.inventManager.services.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.inventManager.dto.requests.CreateStoreDTO;
import com.example.inventManager.models.Store;
import com.example.inventManager.payload.ApiResponse;
import com.example.inventManager.repositories.StoreRepository;
import com.example.inventManager.services.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    @Override
    public ResponseEntity<ApiResponse> getStoreById(UUID storeId) {
        try {
            Optional<Store> store = storeRepository.findById(storeId);
            if (store == null)
                throw new BadRequestException("The store with the provided id is not found");
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse(true, "The store retrieved successfully", store));
        } catch (BadRequestException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(false, exception.getMessage()));
        }
    }

    @Override
    public ResponseEntity<ApiResponse> createStore(CreateStoreDTO createStoreDTO) {
        Store store = new Store(createStoreDTO.getName());
        return ResponseEntity.ok().body(new ApiResponse(
                true,
                "Successfully created store",
                store));
    }

    @Override
    public void deleteStore(UUID storeId) {
        storeRepository.deleteById(storeId);
    }
}