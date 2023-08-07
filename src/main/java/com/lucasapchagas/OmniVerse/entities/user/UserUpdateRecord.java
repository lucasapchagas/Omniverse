package com.lucasapchagas.OmniVerse.entities.user;

import jakarta.validation.constraints.NotNull;

public record UserUpdateRecord(
        @NotNull
        Long id,
        String name,
        String cep) {
}
