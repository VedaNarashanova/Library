package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.dto.BookDto;
import com.example.library.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> findById(Long id);

    List<Book> listAll();

    Optional<Book> create(BookDto bookDto);

    Optional<Book> update(Long id, BookDto bookDto);


    //   Optional<Book> create(String name, String categoryName, Long authorId, Integer availableCopies);

 //   Optional<Book> update(Long id, String name, String categoryName, Long authorId, Integer availableCopies);

    void delete(Long id);
    void rent(Long id);

    void onBookCreated();
    void onBookEdited();
    void onBookDeleted();

    void onBookCompleatlyBorrowed();

    List<Category> getAllCategories();

//    List<Book> filter(BookDto bookDto, Integer availableCopies);

}
