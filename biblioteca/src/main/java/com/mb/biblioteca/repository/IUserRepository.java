package com.mb.biblioteca.repository;

import com.mb.biblioteca.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Page<User> findAll(Pageable pageable);

    Optional<UserDetails> findUserBymatricula(String username);

    Optional<User> findByNome(String username);
}
