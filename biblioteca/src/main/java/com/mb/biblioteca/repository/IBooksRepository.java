package com.mb.biblioteca.repository;

import com.mb.biblioteca.model.Books;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBooksRepository extends JpaRepository<Books, Long> {
    Page<Books> findAll(Pageable pageable);
    Optional<Books> findByTitle(String titulo);

}
