package com.library.Library.models;

import jakarta.persistence.*;

@Entity
@Table(name="Ejemplar")
public class Copy {


    @ManyToOne
    @JoinColumn(name = "id_libro")
    private Book book;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SQ_ID_EJEMPLAR")
    @SequenceGenerator(name = "SQ_ID_EJEMPLAR",sequenceName="SQ_ID_EJEMPLAR",allocationSize = 1)
    @Column(name ="id_ejemplar")
    private Long copyId;


    @Column(name="codigo_barra")
    private String barCode;
    @Column(name="estado")
    private String status;


    public Copy(){

    }

    public Copy(Book book, Long copyId, String barCode, String status) {
        this.book = book;
        this.copyId = copyId;
        this.barCode = barCode;
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Long getCopyId() {
        return copyId;
    }

    public void setCopyId(Long copyId) {
        this.copyId = copyId;
    }


    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

