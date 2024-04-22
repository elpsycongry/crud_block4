package com.example.crud1.service;

import com.example.crud1.model.User;
import com.example.crud1.repository.IClassRepository;
import com.example.crud1.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IClassRepository classRepository;
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public List<User> getAllUserWithSearch(String search){
        return userRepository.findAll();
    }
    public IUserRepository getUserRepository(){
        return userRepository;
    }
}
