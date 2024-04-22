package com.example.library.service;

import com.example.library.model.Author;
import com.example.library.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    Optional<Country> findById(Long id);

    List<Country> listAll();

    Optional<Country> create(String name, String continent);

    Optional<Country> update(Long id, String name,String continent);

    void delete(Long id);
}
