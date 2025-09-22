package com.library.Library.controller;

import com.library.Library.models.Copy;
import com.library.Library.models.Publisher;
import com.library.Library.services.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/copy")
public class CopyController {
    @Autowired
    private CopyService copyService;

    @GetMapping("/find")
    public List<Copy> findAll() {
        return this.copyService.findAll();
    }

    @GetMapping("/{id}")
    public Copy findById(@PathVariable("id") Long copyId) {
        return this.copyService.findById(copyId);
    }

    @PostMapping("/save")
    public Copy save(@RequestBody Copy copy){
        return this.copyService.saveCopy(copy);
    }

    @PutMapping("/update/{id}")
    public Copy update(@PathVariable("id") Long copyId, @RequestBody Copy newCopy){
        return this.copyService.updateCopy(copyId,newCopy);
    }
}
