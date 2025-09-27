package com.pm.authservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginRequestDTO {
    @NotBlank(message = "Email Is Required")
    @Email(message = "Email should be a valid email")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8 , message = "Password must be atleast 8 characters long")
    private String password;

    public @NotBlank(message = "Email Is Required") @Email(message = "Email should be a valid email") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email Is Required") @Email(message = "Email should be a valid email") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Password is required") @Size(min = 8, message = "Password must be atleast 8 characters long") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password is required") @Size(min = 8, message = "Password must be atleast 8 characters long") String password) {
        this.password = password;
    }
}
