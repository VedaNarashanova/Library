package com.example.library.model.dto;

import lombok.Data;

@Data
public class CountryDto {

     String name;

     String continent;

    public CountryDto() {
    }

    public CountryDto(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
}
