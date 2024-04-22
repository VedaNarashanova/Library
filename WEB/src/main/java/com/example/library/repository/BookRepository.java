package com.example.library.repository;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.model.enumerations.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

//    List<Book> findBookByCategoryAndAvailableCopies(Bookdto bookdto, Integer availableCopies);
}
