package com.example.library.model.dto;

import com.example.library.model.enumerations.Category;
import lombok.Data;

@Data
public class BookDto {
     private String name;

     private Category category;

     private Long authorId;

     private Integer availableCopies;

//    public BookDto() {
//    }

    public BookDto(String name, Category category, Long authorId, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }
}
