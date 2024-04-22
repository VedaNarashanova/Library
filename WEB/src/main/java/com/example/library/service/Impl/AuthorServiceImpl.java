package com.example.library.service.Impl;

import com.example.library.model.Author;
import com.example.library.model.Country;
import com.example.library.model.exceptions.InvalidAuthorIdException;
import com.example.library.model.exceptions.InvalidCountryIdException;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.CountryRepository;
import com.example.library.repository.view.AuthorsPerBookViewRepository;
import com.example.library.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    private final CountryRepository countryRepository;

    private final AuthorsPerBookViewRepository authorsPerBookViewRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository, AuthorsPerBookViewRepository authorsPerBookViewRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
        this.authorsPerBookViewRepository = authorsPerBookViewRepository;
    }

    @Override
    public List<Author> listAll() {
        return this.authorRepository.findAll();
    }


    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);

    }


    @Override
    public Optional<Author> create(String name, String surname, Long countryId) {
        Country country=this.countryRepository.findById(countryId).orElseThrow(InvalidCountryIdException::new);
        Author author=new Author(name,surname,country);
        return Optional.of(this.authorRepository.save(author));
    }

    @Override
    public Optional<Author> update(Long id, String name, String surname, Long country) {
        Author author=this.authorRepository.findById(id).orElseThrow(InvalidAuthorIdException::new);
        Country country1=this.countryRepository.findById(country).orElseThrow(InvalidCountryIdException::new);

        author.setName(name);
        author.setSurname(surname);
        author.setCountry(country1);
        return Optional.of(this.authorRepository.save(author));
    }

    @Override
    public void delete(Long id) {
        Author author=this.authorRepository.findById(id).orElseThrow(InvalidAuthorIdException::new);
        this.authorRepository.delete(author);
    }

//    @Override
//    public void refreshMaterializedView() {
//        this.authorsPerBookViewRepository.refreshMaterializedView();
//    }




}

