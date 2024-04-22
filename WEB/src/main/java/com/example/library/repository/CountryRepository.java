package com.example.library.repository;

import com.example.library.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
}
