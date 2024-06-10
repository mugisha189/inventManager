package com.example.inventManager.dto.requests;
import jakarta.validation.constraints.*;
import lombok.Getter;


@Getter
public class CreateUserDTO {
    @NotNull
    @Email
    private String email;

    @Size(min = 5, max = 20)
    private String username;

    @Size(min = 8, max = 20)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, and one digit.")
    private String password;
}
