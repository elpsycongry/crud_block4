package com.example.crud1.controller;

import com.example.crud1.model.User;
import com.example.crud1.repository.IClassRepository;
import com.example.crud1.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class RestUserController {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IClassRepository classRepository;
    @GetMapping("/class")
    public ResponseEntity<List<User>> getListUser(){
        List<User> list = userRepository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<User> addUser(@RequestBody User user){
        User userRes = userRepository.save(user);
        if (userRes != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
    }
}
