package com.lab4.Library.service;

import com.lab4.Library.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {
    AuthorDTO findDTOById(Long id);
    void deleteById(Long id);
    List<AuthorDTO> findAll();
    AuthorDTO save(AuthorDTO user);
    AuthorDTO update(AuthorDTO user);

    AuthorDTO findAuthorByNameAndSurname(String name, String surname);

}
