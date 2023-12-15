package com.lab4.Library.repository;

import com.lab4.Library.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    List<Publisher> findAllByIsActiveTrue();
}
