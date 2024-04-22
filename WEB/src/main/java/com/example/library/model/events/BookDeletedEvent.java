package com.example.library.model.events;

import com.example.library.model.Book;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;
@Getter
public class BookDeletedEvent extends ApplicationEvent {

    private LocalDateTime when;

    public BookDeletedEvent(Book source) {
        super(source);
        this.when=LocalDateTime.now();
    }

    public BookDeletedEvent(Book source, LocalDateTime when) {
        super(source);
        this.when = when;
    }
}
