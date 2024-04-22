package com.example.library.service;

import com.example.library.model.Author;
import com.example.library.model.Country;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> listAll();

    Optional<Author> findById(Long id);

    Optional<Author> create(String name, String surname, Long countryId);

    Optional<Author> update(Long id,String name, String surname, Long country);

    void delete(Long id);

    //void refreshMaterializedView();
}
