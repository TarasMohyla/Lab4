package com.lab4.Library.service;

import com.lab4.Library.dto.AuthorDTO;
import com.lab4.Library.dto.PublisherDTO;
import com.lab4.Library.entity.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {
    PublisherDTO findDTOById(Long id);
    void deleteById(Long id);
    List<PublisherDTO> findAll();
    PublisherDTO save(PublisherDTO user);
    PublisherDTO update(PublisherDTO user);
}
