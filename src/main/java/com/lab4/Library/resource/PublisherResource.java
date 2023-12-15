package com.lab4.Library.resource;


import com.lab4.Library.dto.AuthorDTO;
import com.lab4.Library.dto.PublisherDTO;
import com.lab4.Library.service.PublisherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherResource {

    @Autowired
    private PublisherService publisherService;


    @GetMapping("/{id}")
    public PublisherDTO findById(final @PathVariable Long id){
        return publisherService.findDTOById(id);
    }

    @GetMapping
    public List<PublisherDTO> findAll(){
        return publisherService.findAll();
    }

    @PostMapping
    public ResponseEntity createPublisher(final @RequestBody @Valid PublisherDTO publisherDTO){
        final PublisherDTO responseBody = publisherService.save(publisherDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    @PutMapping
    public PublisherDTO updatePublisher(final @RequestBody PublisherDTO publisherDTO){
        return publisherService.update(publisherDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(final @PathVariable Long id){
        publisherService.deleteById(id);
    }

}

