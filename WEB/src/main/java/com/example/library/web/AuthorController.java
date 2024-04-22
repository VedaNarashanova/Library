package com.example.library.web;

import com.example.library.model.Author;
import com.example.library.model.dto.AuthorDto;
import com.example.library.service.AuthorService;
import com.example.library.service.BookService;
import com.example.library.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class AuthorController {
    private final AuthorService authorService;
    protected final BookService bookService;
    private final CountryService countryService;

    public AuthorController(AuthorService authorService, BookService bookService, CountryService countryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
    }

    @GetMapping("/authors")
    public List<Author> listAll(){
        return this.authorService.listAll();
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id) {
        return authorService.findById(id)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add-author")
    public ResponseEntity<Author> save(@RequestBody AuthorDto authorDto) {
        return this.authorService.create(authorDto.getName(),authorDto.getSurname(),authorDto.getCountryId())
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }


    @PostMapping("/edit-author/{id}")
    public ResponseEntity<Author> editAuthor(@PathVariable Long id,
                                             @RequestBody AuthorDto authorDto) {
        return this.authorService.update(id,authorDto.getName(),authorDto.getSurname(),authorDto.getCountryId())
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }


    @DeleteMapping("/delete-author/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable Long id){
        this.authorService.delete(id);
        if (this.authorService.findById(id).isEmpty())
            return ResponseEntity.ok().build();

        return ResponseEntity.badRequest().build();
    }
}
