package com.example.inventManager.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse {
    public boolean success;
    public String message;
    public Object data;
    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
