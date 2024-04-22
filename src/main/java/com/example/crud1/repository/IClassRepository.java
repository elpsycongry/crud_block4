package com.example.crud1.repository;

import com.example.crud1.model.ClassUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IClassRepository extends JpaRepository<ClassUser, Long> {

}
