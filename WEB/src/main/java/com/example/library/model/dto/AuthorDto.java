package com.example.library.model.dto;

import com.example.library.model.Country;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class AuthorDto {

     String name;

     String surname;

     Long countryId;

    public AuthorDto() {
    }

    public AuthorDto(String name, String surname, Long countryId) {
        this.name = name;
        this.surname = surname;
        this.countryId = countryId;
    }
}
