package com.example.library.model.events;

import com.example.library.model.Book;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;
@Getter
public class BookEditedEvent extends ApplicationEvent {

    private LocalDateTime when;

    public BookEditedEvent(Book source) {
        super(source);
        this.when=LocalDateTime.now();
    }

    public BookEditedEvent(Book source, LocalDateTime when) {
        super(source);
        this.when = when;
    }
}
