package com.example.library.web;

import com.example.library.model.Author;
import com.example.library.model.Country;
import com.example.library.model.dto.AuthorDto;
import com.example.library.model.dto.CountryDto;
import com.example.library.service.AuthorService;
import com.example.library.service.BookService;
import com.example.library.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class CountryController {
    private final AuthorService authorService;
    protected final BookService bookService;
    private final CountryService countryService;

    public CountryController(AuthorService authorService, BookService bookService, CountryService countryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public List<Country> listAll(){
        return this.countryService.listAll();
    }

    @GetMapping("/country/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id) {
        return authorService.findById(id)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add-country")
    public ResponseEntity<Country> addACountry(@RequestBody CountryDto countryDto){
        return this.countryService.create(countryDto.getName(),countryDto.getContinent())
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @PutMapping("/edit-country/{id}")
    public ResponseEntity<Country> editCountry(@PathVariable Long id,
                                           @RequestBody CountryDto countryDto){
        return this.countryService.update(id,countryDto.getName(),countryDto.getContinent())
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete-country/{id}")
    public ResponseEntity<Country> deleteCountry(@PathVariable Long id){
        this.countryService.delete(id);
        if (this.countryService.findById(id).isEmpty())
            return ResponseEntity.ok().build();

        return ResponseEntity.badRequest().build();
    }

}
