package com.lab4.Library.service;

import com.lab4.Library.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> findAll();

    BookDTO findDTOById(Long Id);

    BookDTO save(BookDTO bookDTO);

    void deleteById(Long Id);

    BookDTO update(BookDTO bookDto);

    BookDTO findBookByTitle(String Title);

    List<BookDTO> findByPrice(Integer price);

    List<BookDTO> findByAuthorNameAndPrice(String authorName, Integer price);


}
