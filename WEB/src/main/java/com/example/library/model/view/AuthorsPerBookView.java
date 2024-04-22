package com.example.library.model.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Data
@Entity
@Subselect("SELECT * FROM public.authors_per_book")
@Immutable
public class AuthorsPerBookView {

    @Id
    @Column(name="author_id")
    private Long AuthorId;

//    @Column(name = "names")
    private Long name;

//    @Column(name = "surnames")
    private Long surname;

}
