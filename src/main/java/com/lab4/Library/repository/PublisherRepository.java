package com.lab4.Library.repository;

import com.lab4.Library.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    List<Publisher> findAllByIsActiveTrue();
}
