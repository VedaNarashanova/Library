package com.example.library.service.Impl;

import com.example.library.model.Country;
import com.example.library.model.exceptions.InvalidCountryIdException;
import com.example.library.repository.CountryRepository;
import com.example.library.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public List<Country> listAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> create(String name, String continent) {
        Country country=new Country(name,continent);
        return Optional.of(this.countryRepository.save(country));
    }

    @Override
    public Optional<Country> update(Long id, String name, String continent) {
        Country country=this.countryRepository.findById(id).orElseThrow(InvalidCountryIdException::new);
        country.setName(name);
        country.setContinent(continent);
        return Optional.of(this.countryRepository.save(country));
    }

    @Override
    public void delete(Long id) {
        Country country=this.countryRepository.findById(id).orElseThrow(InvalidCountryIdException::new);
        this.countryRepository.delete(country);

    }
}
