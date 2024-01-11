package com.lab4.Library.repository;
import com.lab4.Library.dto.AuthorDTO;
import com.lab4.Library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAllByIsActiveTrue();

    Author findAuthorByNameAndSurname(String name, String surname);

}
