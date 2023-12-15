package com.lab4.Library.dto;

import com.lab4.Library.entity.Author;
import com.lab4.Library.entity.Book;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO{

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    private List<Book> books;

    public static AuthorDTO toDTO(final Author author){
        final AuthorDTO authorDTO = new AuthorDTO();

        authorDTO.setId(author.getId());
        authorDTO.setName(author.getName());
        authorDTO.setBooks(author.getBooks());
        authorDTO.setSurname(author.getSurname());

        return authorDTO;
    }

}
