package com.example.library.listeners;

import com.example.library.model.events.BookCompleatplyBorrowedEvent;
import com.example.library.model.events.BookCreatedEvent;
import com.example.library.model.events.BookDeletedEvent;
import com.example.library.model.events.BookEditedEvent;
import com.example.library.service.BookService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BookEventHandlers {
    private final BookService bookService;

    public BookEventHandlers(BookService bookService) {
        this.bookService = bookService;
    }

    @EventListener
    public void onBookCreated(BookCreatedEvent event) {
        this.bookService.onBookCreated();
    }

    @EventListener
    public void onBookDeleted(BookDeletedEvent event) {
        this.bookService.onBookDeleted();
    }

    @EventListener
    public void onBookEdited(BookEditedEvent event) {
        this.bookService.onBookEdited();
    }

    @EventListener
    public void onBookCompleatlyBorrowed(BookCompleatplyBorrowedEvent event){
        this.bookService.onBookCompleatlyBorrowed();
    }

//    private final BookService bookService;
//
//    public BookEventHandlers(BookService bookService) {
//        this.bookService = bookService;
//    }
//
//    public void onBookCreated(BookCreatedEvent event){ //slusha za nekakov tip na event
//        this.bookService.onBookCreated
//    }
}
