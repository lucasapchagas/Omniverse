package com.lucasapchagas.OmniVerse.entities.common;

import com.lucasapchagas.OmniVerse.external.ViacepRecord;
import com.lucasapchagas.OmniVerse.utils.Formatter;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AddressRecord (
        @NotNull
        @Pattern(regexp = "\\d{8}")
        String cep,
        String place,
        String complement,
        String neighborhood,
        String locality,
        String uf) {

        public AddressRecord(ViacepRecord viacepRecord) {
                this(
                        Formatter.cep(viacepRecord.cep()),
                        viacepRecord.logradouro(),
                        viacepRecord.complemento(),
                        viacepRecord.bairro(),
                        viacepRecord.localidade(),
                        viacepRecord.uf()
                );
        }
}
