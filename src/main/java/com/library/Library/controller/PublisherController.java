package com.library.Library.controller;

import com.library.Library.models.Publisher;
import com.library.Library.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/find")
    public List<Publisher> findAll() {
        return this.publisherService.findAll();
    }

    @GetMapping("/{id}")
    public Publisher findById(@PathVariable("id") Long publisherId) {
        return this.publisherService.findById(publisherId);
    }

    @PostMapping("/save")
    public Publisher save(@RequestBody Publisher publisher){
        return this.publisherService.savePublisher(publisher);
    }

    @PutMapping("/update/{id}")
    public Publisher update(@PathVariable("id") Long publisherId, @RequestBody Publisher newPublisher){
        return this.publisherService.updatePublisher(publisherId,newPublisher);
    }

}
