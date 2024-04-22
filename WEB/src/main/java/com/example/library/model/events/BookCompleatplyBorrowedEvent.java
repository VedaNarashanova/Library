package com.example.library.model.events;

import com.example.library.model.Book;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class BookCompleatplyBorrowedEvent extends ApplicationEvent {

    Long bookId;

    public BookCompleatplyBorrowedEvent(Book source) {
        super(source);
        this.bookId=source.getId();
    }
}
