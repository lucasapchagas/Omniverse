package com.lucasapchagas.OmniVerse.entities.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lucasapchagas.OmniVerse.entities.common.Address;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity(name = "User")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;

    @Embedded
    private Address address;

    public User(@Valid UserCreateRecord userRecord) {
        this.name = userRecord.name();
        this.email = userRecord.email();
        this.address = new Address(userRecord.cep());
    }

    public void update(UserUpdateRecord data) {
        if (data.name() != null)
            this.name = data.name();
        if (data.cep() != null)
            this.address = new Address(data.cep());
    }
}
