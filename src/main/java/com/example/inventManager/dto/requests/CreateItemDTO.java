package com.example.inventManager.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;


@Getter
public class CreateItemDTO {

    @NotBlank
    private String name;

    @NotNull
    @Positive
    private Double quantity;

    @NotNull
    @Positive
    private Double price;

}
