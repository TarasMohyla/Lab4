package com.lab4.Library.dto;


import com.lab4.Library.entity.Author;
import com.lab4.Library.entity.Book;
import com.lab4.Library.entity.Publisher;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long id;

    @NotNull
    private String title;

    private String description;

    @NotNull
    private Author author;

    @NotNull
    private Publisher publisher;

    @Positive
    private Integer price;


    public static BookDTO toDTO(final Book book){
        final BookDTO bookDTO = new BookDTO();

        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setDescription(book.getDescription());
        bookDTO.setPrice(book.getPrice());
        bookDTO.setPublisher(book.getPublisher());

        return bookDTO;
    }
}
