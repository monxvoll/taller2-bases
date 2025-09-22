package com.library.Library.controller;


import com.library.Library.models.Book;
import com.library.Library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/find")
    public List<Book> findAll() {
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable("id") Long bookId) {
        return this.bookService.findById(bookId);
    }

    @PostMapping("/save")
    public Book save(@RequestBody Book book){
        return this.bookService.saveBook(book);
    }

    @PutMapping("/update/{id}")
    public Book update(@PathVariable("id") Long bookId, @RequestBody Book newBook){
        return this.bookService.updateBook(bookId,newBook);
    }

    @GetMapping("/by-publisher/{id}")
    public List<Book> getBookP(@PathVariable("id") Long bookId){
        return this.bookService.getBookByPublisher(bookId);
    }
}
