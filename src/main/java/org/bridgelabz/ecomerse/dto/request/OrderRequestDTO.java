package org.bridgelabz.ecomerse.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OrderRequestDTO {
    @NotNull(message = "Name cannot be null")
    String name;
    @NotBlank
    int value;
    @Email
    String email;
}
