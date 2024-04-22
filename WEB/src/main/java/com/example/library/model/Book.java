package com.example.library.model;


import com.example.library.model.enumerations.Category;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String name;

   // @Enumerated(EnumType.STRING) so ova se pojavuva null bez ova e ok
    @Enumerated(EnumType.ORDINAL)
    private Category category;


    //@OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    private Author author;

    private  Integer availableCopies;


    public Book() {
    }

    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
