package com.lab4.Library.service.impl;


import com.lab4.Library.dto.AuthorDTO;
import com.lab4.Library.dto.PublisherDTO;
import com.lab4.Library.entity.Author;
import com.lab4.Library.entity.Publisher;
import com.lab4.Library.exceptions.AuthorServiceException;
import com.lab4.Library.exceptions.BadRequestException;
import com.lab4.Library.exceptions.PublisherServiceException;
import com.lab4.Library.repository.PublisherRepository;
import com.lab4.Library.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private PublisherRepository publisherRepository;
    @Override
    public PublisherDTO findDTOById(final Long id) {
        final Publisher publisher = findById(id);

        return PublisherDTO.toDTO(publisher);
    }

    private Publisher findById(final Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new PublisherServiceException(String.format("Publisher with id {%s} not found", id)));
    }


    @Override
    public List<PublisherDTO> findAll() {
        return publisherRepository.findAllByIsActiveTrue().stream()
                .map(PublisherDTO::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PublisherDTO save(final PublisherDTO publisherDTO) {
        final Publisher publisher = new Publisher();

       publisher.setId(publisherDTO.getId());
       publisher.setName(publisherDTO.getName());
       publisher.setBooks(publisherDTO.getBooks());


        return PublisherDTO.toDTO(publisher);
    }

    @Override
    public void deleteById(final Long id) {
        final Publisher publisher = findById(id);
        publisher.setIsActive(Boolean.FALSE);
        publisherRepository.save(publisher);
    }

    @Override
    public PublisherDTO update(final PublisherDTO publisherDTO) {
        if (publisherDTO.getId() == null) {
            throw new BadRequestException("Id can't be null");
        }

        final Publisher savedPublisher = findById(publisherDTO.getId());
        savedPublisher.setId(publisherDTO.getId());
        savedPublisher.setName(publisherDTO.getName());
        savedPublisher.setBooks(publisherDTO.getBooks());

        return PublisherDTO.toDTO(savedPublisher);
    }

}
