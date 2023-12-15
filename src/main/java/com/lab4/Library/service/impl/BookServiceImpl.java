package com.lab4.Library.service.impl;

import com.lab4.Library.dto.BookDTO;
import com.lab4.Library.entity.Book;
import com.lab4.Library.exceptions.BadRequestException;
import com.lab4.Library.exceptions.BookServiceException;
import com.lab4.Library.repository.BookRepository;
import com.lab4.Library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<BookDTO> findAll() {
        return bookRepository.findAllByIsActiveTrue()
                .stream()
                .map(BookDTO::toDTO)
                .toList();
    }

    @Override
    public BookDTO findDTOById(final Long Id) {
        final Book book = findById(Id);

        return BookDTO.toDTO(book);
    }

    private Book findById(final Long Id) {
        return bookRepository.findById(Id)
                .orElseThrow(() -> new BadRequestException(String.format("Book with id {%s} not found", Id)));
    }

    @Override
    public BookDTO save(final BookDTO bookDTO) {
        final Book book = new Book();

        book.setId(bookDTO.getId());
        book.setAuthor(bookDTO.getAuthor());
        book.setTitle(bookDTO.getTitle());
        book.setPrice(bookDTO.getPrice());
        book.setPublisher(bookDTO.getPublisher());
        book.setDescription(book.getDescription());


        bookRepository.save(book);

        return BookDTO.toDTO(book);
    }

    @Override
    public void deleteById(final Long Id) {
        final Book book = findById(Id);
        book.setIsActive(Boolean.FALSE);
        bookRepository.save(book);
    }

    @Override
    public BookDTO update(final BookDTO bookDto) {
        if (bookDto.getId() == null) {
            throw new BadRequestException("Id can't be null");
        }

        final Book book = findById(bookDto.getId());

        book.setAuthor(bookDto.getAuthor());
        book.setDescription(bookDto.getDescription());
        book.setPrice(bookDto.getPrice());
        book.setId(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        book.setPublisher(bookDto.getPublisher());
        bookRepository.save(book);

        return BookDTO.toDTO(book);

    }

    @Override
    public BookDTO findBookByTitle(final String title) {
        return BookDTO.toDTO(bookRepository.findByTitle(title));
    }

    @Override
    public List<BookDTO> findByPrice(final Integer price) {
        return bookRepository.findByPrice(price)
                .stream()
                .map(BookDTO::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public List<BookDTO> findByAuthorNameAndPrice(final String authorName, final Integer price) {
        final List<Book> books = bookRepository.findByAuthorNameAndPrice(authorName, price);
        return books.stream().map(BookDTO::toDTO).collect(Collectors.toList());
    }


}
