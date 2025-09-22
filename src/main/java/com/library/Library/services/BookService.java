package com.library.Library.services;


import com.library.Library.models.Book;
import com.library.Library.models.Publisher;
import com.library.Library.repositories.BookRepository;
import com.library.Library.repositories.CopyRepository;
import com.library.Library.repositories.PublisherRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private CopyRepository copyRepository;

    public List<Book> findAll(){
        return this.bookRepository.findAll();
    }

    public Book findById(Long id){
        return this.bookRepository.findById(id).orElseThrow();
    }

    public Book saveBook(Book book){
        Publisher publisher = this.publisherRepository.findById(book.getPublisher().getPublisherId()).orElse(null);
        book.setPublisher(publisher);

        return this.bookRepository.save(book);
    }

    public Book updateBook(Long bookId, Book newBook){
        Book bk = this.bookRepository.findById(bookId).orElse(null);
        assert bk != null;
        BeanUtils.copyProperties(newBook,bk,"id_matricula");
        return  this.bookRepository.save(bk);
    }

    public List<Book> getBookByPublisher(Long bookId){
        return this.bookRepository.getBookByPublisher(bookId);
    }
}
