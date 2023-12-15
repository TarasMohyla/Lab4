package com.lab4.Library.dto;

import com.lab4.Library.entity.Author;
import com.lab4.Library.entity.Book;
import com.lab4.Library.entity.Publisher;
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
public class PublisherDTO {

    private Long id;

    @NotNull
    private String name;

    private List<Book> books;


    public static PublisherDTO toDTO(final Publisher publisher){
        final PublisherDTO publisherDTO = new PublisherDTO();

        publisherDTO.setId(publisher.getId());
        publisherDTO.setName(publisher.getName());
        publisherDTO.setBooks(publisher.getBooks());

        return publisherDTO;
    }
}
