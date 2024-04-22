package com.example.library.service.Impl;

import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.model.dto.BookDto;
import com.example.library.model.enumerations.Category;
import com.example.library.model.events.BookCompleatplyBorrowedEvent;
import com.example.library.model.events.BookCreatedEvent;
import com.example.library.model.events.BookDeletedEvent;
import com.example.library.model.exceptions.AuthorNotFoundException;
import com.example.library.model.exceptions.BookNotFoundException;
import com.example.library.model.exceptions.InavlidBookIdExceptio;
import com.example.library.model.exceptions.InvalidAuthorIdException;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.service.AuthorService;
import com.example.library.service.BookService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final AuthorService authorService;

    private final ApplicationEventPublisher applicationEventPublisher;


    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, AuthorService authorService, ApplicationEventPublisher applicationEventPublisher) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.authorService = authorService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> create(BookDto bookDto) {
        Category category = bookDto.getCategory();
//        Category category=Category.valueOf(bookDto.getCategory().name());
        Author author = authorService.findById(bookDto.getAuthorId()).orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));
        Book book = new Book(bookDto.getName(),category,author,bookDto.getAvailableCopies());
        bookRepository.save(book);
        applicationEventPublisher.publishEvent(new BookCreatedEvent(book));
        return Optional.of(book);
    }

    @Override
    public Optional<Book> update(Long id, BookDto bookDto) {
        Author author = authorService.findById(bookDto.getAuthorId()).orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));
//        Category category=Category.valueOf(bookDto.getCategory().name());
        Category category = bookDto.getCategory();
        Book book = findById(id).orElseThrow(() -> new BookNotFoundException(id));
        book.setName(bookDto.getName());
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        bookRepository.save(book);
        return Optional.of(book);
    }


//    @Override//save
//    public Optional<Book> create(String name, Category category, Long authorId, Integer availableCopies) {
//        Author author1=this.authorRepository.findById(authorId).orElseThrow((InvalidAuthorIdException::new)); //dali ova e ok????
//        //Category category1=Category.valueOf(category);
//        Book book=new Book(name,category,author1,availableCopies);
//        this.applicationEventPublisher.publishEvent(new BookCreatedEvent(book));
//        return Optional.of(this.bookRepository.save(book));
//    }
//
//
//    @Override//edit
//    public Optional<Book>  update(Long id, String name, Category category, Long authorId, Integer availableCopies) {
//        Book book=this.bookRepository.findById(id).orElseThrow(InavlidBookIdExceptio::new);
//        Author author1=this.authorRepository.findById(authorId).orElseThrow(InvalidAuthorIdException::new);
//      //  Category category1=Category.valueOf(category);
//        book.setName(name);
//        book.setCategory(category);
//        book.setAuthor(author1);
//        book.setAvailableCopies(availableCopies);
//
//        this.applicationEventPublisher.publishEvent(new BookEditedEvent(book));
//        return Optional.of(this.bookRepository.save(book));
//    }

    @Override
    public void delete(Long id) {
        Book book=this.bookRepository.findById(id).orElseThrow(InavlidBookIdExceptio::new);
        this.applicationEventPublisher.publishEvent(new BookDeletedEvent(book));
        this.bookRepository.delete(book);

    }
    @Override
    public void rent(Long id) {
        Book book=this.bookRepository.findById(id).orElseThrow(InavlidBookIdExceptio::new);
        if(book.getAvailableCopies()>0) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            this.bookRepository.save(book);
        }
        else
            applicationEventPublisher.publishEvent(new BookCompleatplyBorrowedEvent(book));
    }

    @Override
    public void onBookCreated() {
        System.out.println("Book CREATED sucessfuly");
    }

    @Override
    public void onBookEdited() {
        System.out.println("Book EDITED sucessfuly");

    }

    @Override
    public void onBookDeleted() {
        System.out.println("Book DELETED sucessfuly");

    }

    @Override
    public void onBookCompleatlyBorrowed() {
        System.out.println("Book BORROWED sucessfuly");

    }

    @Override
    public List<Category> getAllCategories() {
        return Arrays.stream(Category.values()).toList();
    }

//    @Override
//    public List<Book> filter(BookDto bookDto,Integer availableCopies) {
//        Category category = bookDto.getCategory();
//        if (category != null && availableCopies > 2) {
//            return this.bookRepository.findBookByCategoryAndAvailableCopies(category,availableCopies);
//        }
//    }
}
