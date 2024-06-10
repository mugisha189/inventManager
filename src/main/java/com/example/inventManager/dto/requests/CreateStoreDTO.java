package com.example.inventManager.dto.requests;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class CreateStoreDTO {
    @Size(min = 5, max = 20)
    private String name;
}
