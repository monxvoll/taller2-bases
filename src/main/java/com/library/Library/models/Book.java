package com.library.Library.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;



@Entity
@Table(name="Libro")

public class Book {

    @ManyToOne
    @JoinColumn(name = "id_editorial")
    private Publisher publisher;

    @OneToMany(mappedBy = "book")
    @JsonIgnoreProperties("book")
    private List<Copy> copyList;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SQ_ID_LIBRO")
    @SequenceGenerator(name = "SQ_ID_LIBRO",sequenceName="SQ_ID_LIBRO",allocationSize = 1)
    @Column(name ="id_libro")
    private Long bookId;


    @Column(name="titulo")
    private String title;

    @Column(name="anio_publicacion")
    private Integer publicationYear;

    public Book(){

    }

    public Book(Publisher publisher, Long bookId, String title, Integer publicationYear) {
        this.publisher = publisher;
        this.bookId = bookId;
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }
}
