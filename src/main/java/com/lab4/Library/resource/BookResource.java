package com.lab4.Library.resource;

import com.lab4.Library.dto.BookDTO;
import com.lab4.Library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
public class BookResource {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public BookDTO findById(final @PathVariable Long id){
        return bookService.findDTOById(id);
    }

    @GetMapping
    public List<BookDTO> findAll(){
        return bookService.findAll();
    }

    @PostMapping
    public ResponseEntity createBook(final @RequestBody @Valid BookDTO bookDTO){
        final BookDTO responseBody = bookService.save(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }
    @PutMapping
    public BookDTO updateBook(final @RequestBody BookDTO book){
        return bookService.update(book);
    }


    @DeleteMapping("/{id}")
    public void deleteById(final @PathVariable Long id){
        bookService.deleteById(id);
    }


    @GetMapping("/search")
    public ResponseEntity<BookDTO> find(final @RequestParam String title){
        final BookDTO responseBody = bookService.findBookByTitle(title);
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/search-by-price")
    public ResponseEntity<List<BookDTO>> findBooksByPrice(@RequestParam final Integer price) {
        final List<BookDTO> books = bookService.findByPrice(price);
        return ResponseEntity.ok(books);
    }



    @GetMapping("/search-by-author-and-price")
    public ResponseEntity<List<BookDTO>> findByAuthorNameAndPrice(
            @RequestParam final String authorName,
            @RequestParam final Integer price
    ) {
        final List<BookDTO> books = bookService.findByAuthorNameAndPrice(authorName, price);
        return ResponseEntity.ok(books);
    }




}
