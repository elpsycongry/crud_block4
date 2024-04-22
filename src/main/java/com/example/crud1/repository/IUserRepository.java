package com.example.crud1.repository;

import com.example.crud1.model.ClassUser;
import com.example.crud1.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Long> {
    Page<User> findAllByNameContainingIgnoreCase(String name, Pageable pageable);
}
