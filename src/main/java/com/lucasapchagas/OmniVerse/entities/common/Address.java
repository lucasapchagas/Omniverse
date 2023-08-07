package com.lucasapchagas.OmniVerse.entities.common;

import com.lucasapchagas.OmniVerse.external.RequestCep;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String cep;
    private String place;
    private String complement;
    private String neighborhood;
    private String locality;
    private String uf;

    public Address(String cep) {
        AddressRecord addressRecord = new RequestCep(cep).getResult();

        this.cep = addressRecord.cep();
        this.place = addressRecord.place();
        this.complement = addressRecord.complement();
        this.neighborhood = addressRecord.neighborhood();
        this.locality = addressRecord.locality();
        this.uf = addressRecord.uf();

        System.out.println(addressRecord);
    }
}
