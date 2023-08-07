package com.lucasapchagas.OmniVerse.external;

public record ViacepRecord(
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf) {
}
