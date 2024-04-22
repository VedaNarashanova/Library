package com.example.library.model.events;

import com.example.library.model.Book;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;
import java.time.LocalDateTime;

@Getter
public class BookCreatedEvent extends ApplicationEvent {

    private LocalDateTime when; //koga ke se sluci ovoj event za koga se kreiral nekoj produkt

    public BookCreatedEvent(Book source) {
        super(source);
        this.when=LocalDateTime.now();
    }

    public BookCreatedEvent(Book source, LocalDateTime when) {
        super(source);
        this.when = when;
    }

}
