package com.lucasapchagas.OmniVerse.entities.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UserCreateRecord(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotNull
        @Pattern(regexp = "\\d{8}")
        String cep) {
}
