package com.library.Library.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="Editorial")
public class Publisher {

    @OneToMany(mappedBy = "publisher")
    @JsonIgnoreProperties("publisher")
    List<Book> bookList;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SQ_ID_EDITORIAL")
    @SequenceGenerator(name = "SQ_ID_EDITORIAL",sequenceName="SQ_ID_EDITORIAL",allocationSize = 1)
    @Column(name= "id_editorial")
    private Long publisherId;

    @Column(name="nombre")
    private String name;

    @Column(name="pais")
    private String country;


    public Publisher(){

    }
    public Publisher(Long publisherId, String name, String country) {
        this.publisherId = publisherId;
        this.name = name;
        this.country = country;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
