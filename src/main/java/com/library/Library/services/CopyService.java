package com.library.Library.services;


import com.library.Library.models.Book;
import com.library.Library.models.Copy;
import com.library.Library.models.Publisher;
import com.library.Library.repositories.BookRepository;
import com.library.Library.repositories.CopyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CopyService {

    @Autowired
    private CopyRepository copyRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Copy> findAll(){
        return this.copyRepository.findAll();
    }

    public Copy findById(Long id){
        return this.copyRepository.findById(id).orElseThrow();
    }

    public Copy saveCopy(Copy copy){
        Book book = this.bookRepository.findById(copy.getBook().getBookId()).orElse(null);
        copy.setBook(book);

        return this.copyRepository.save(copy);
    }

    public Copy updateCopy(Long copyId, Copy newCopy){
        Copy cy = this.copyRepository.findById(copyId).orElse(null);
        assert cy != null;
        BeanUtils.copyProperties(newCopy,cy,"id_ejemplar");
        return  this.copyRepository.save(cy);
    }
}
