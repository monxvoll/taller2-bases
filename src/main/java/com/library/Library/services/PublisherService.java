package com.library.Library.services;

import com.library.Library.models.Copy;
import com.library.Library.models.Publisher;
import com.library.Library.repositories.PublisherRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> findAll(){
        return this.publisherRepository.findAll();
    }

    public Publisher findById(Long id){
        return this.publisherRepository.findById(id).orElseThrow();
    }

    public Publisher savePublisher(Publisher publisher){
        return this.publisherRepository.save(publisher);
    }

    public Publisher updatePublisher(Long publisherId, Publisher newPublisher){
        Publisher ps = this.publisherRepository.findById(publisherId).orElse(null);
        assert ps != null;
        BeanUtils.copyProperties(newPublisher,ps,"id_editorial");
        return  this.publisherRepository.save(ps);
    }
}
