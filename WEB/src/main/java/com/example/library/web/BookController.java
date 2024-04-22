package com.example.library.web;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.model.dto.BookDto;
import com.example.library.model.enumerations.Category;
import com.example.library.service.AuthorService;
import com.example.library.service.BookService;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;

    }


    @GetMapping("/books")
    public List<Book> listAll(@RequestParam(required = false) Long authorId){
//        if(authorId == null){
            return this.bookService.listAll();
//        }
//        else{
//            return this.bookService.filter(authorId);
//        }

    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/books/categories")
    public List<Category> listAllCategories(){
        return this.bookService.getAllCategories();
    }


    @PostMapping("/add-book")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto){
        return this.bookService.create(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @PostMapping("/edit-book/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id,
                                     @RequestBody BookDto bookDto){
        return this.bookService.update(id,bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete-book/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){
        this.bookService.delete(id);
        if (this.bookService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();

    }



    @GetMapping("/rent/{id}")
    public void rentBook(@PathVariable Long id){
        bookService.rent(id);
    }
//    public ResponseEntity<Book> rent(@PathVariable Long id){
//        if(id==null){
//            return ResponseEntity.notFound().build();
//        }
//        if(bookService.findById(id)==null){
//            return ResponseEntity.notFound().build();
//        }
//        this.bookService.rent(id);
//        return ResponseEntity.ok().build();
//    }





}
