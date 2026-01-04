package com.mb.biblioteca.repository;

import com.mb.biblioteca.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBooksRepository extends JpaRepository<Books, Long> {
}
