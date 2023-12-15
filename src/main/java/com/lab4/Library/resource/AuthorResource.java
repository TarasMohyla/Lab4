package com.lab4.Library.resource;

import com.lab4.Library.dto.AuthorDTO;
import com.lab4.Library.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/author")
public class AuthorResource {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/{id}")
    public AuthorDTO findById(final @PathVariable Long id){
        return authorService.findDTOById(id);
    }

    @GetMapping
    public List<AuthorDTO> findAll(){
        return authorService.findAll();
    }

    @PostMapping
    public ResponseEntity createAuthor(final @RequestBody @Valid AuthorDTO authorDTO){
        final AuthorDTO responseBody = authorService.save(authorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    @PutMapping
    public AuthorDTO updateAuthor(final @RequestBody AuthorDTO authorDTO){
        return authorService.update(authorDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(final @PathVariable Long id){
        authorService.deleteById(id);
    }

}
