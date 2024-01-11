package com.lab4.Library.repository;

import com.lab4.Library.dto.BookDTO;
import com.lab4.Library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByIsActiveTrue();
    Book findByTitle(String title);
    List<Book> findByPrice(Integer price);
    List<Book> findByAuthorNameAndPrice(String name,Integer price);

}

