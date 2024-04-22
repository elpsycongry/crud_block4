package com.example.crud1.service;

import com.example.crud1.repository.IClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassUserService {
    @Autowired
    private IClassRepository classRepository;

    public IClassRepository getClassRepository(){
        return classRepository;
    };
}
