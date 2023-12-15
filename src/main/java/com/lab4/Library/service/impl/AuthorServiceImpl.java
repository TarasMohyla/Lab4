package com.lab4.Library.service.impl;

import com.lab4.Library.dto.AuthorDTO;
import com.lab4.Library.entity.Author;
import com.lab4.Library.exceptions.AuthorServiceException;
import com.lab4.Library.exceptions.BadRequestException;
import com.lab4.Library.repository.AuthorRepository;
import com.lab4.Library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public AuthorDTO findDTOById(final Long id) {
        final Author author = findById(id);

        return AuthorDTO.toDTO(author);
    }

    private Author findById(final Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new AuthorServiceException(String.format("Author with id {%s} not found", id)));
    }


    @Override
    public List<AuthorDTO> findAll() {
        return authorRepository.findAllByIsActiveTrue().stream()
                .map(AuthorDTO::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDTO save(final AuthorDTO authorDTO) {
        final Author author = new Author();

        author.setId(authorDTO.getId());
        author.setName(authorDTO.getName());
        author.setSurname(authorDTO.getSurname());
        author.setBooks(authorDTO.getBooks());


        return AuthorDTO.toDTO(author);
    }

    @Override
    public void deleteById(final Long id) {
        final Author author = findById(id);
        author.setIsActive(Boolean.FALSE);
        authorRepository.save(author);
    }

    @Override
    public AuthorDTO update(final AuthorDTO authorDTO) {
        if (authorDTO.getId() == null) {
            throw new BadRequestException("Id can't be null");
        }

        final Author savedAuthor = findById(authorDTO.getId());
        savedAuthor.setId(authorDTO.getId());
        savedAuthor.setName(authorDTO.getName());
        savedAuthor.setSurname(authorDTO.getSurname());
        savedAuthor.setBooks(authorDTO.getBooks());

        return AuthorDTO.toDTO(savedAuthor);
    }


    @Override
    public AuthorDTO findAuthorByNameAndSurname(final String name, final String surname) {
        final Author author = authorRepository.findAuthorByNameAndSurname(name, surname);
        return AuthorDTO.toDTO(author);
    }
}
