package com.example.crud1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Integer age;
    @ManyToOne()
    @JoinColumn(name = "class_id")
    private ClassUser classUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public ClassUser getClassUser() {
        return classUser;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", classUser=" + classUser +
                '}';
    }

    public void setClassUser(ClassUser classUser) {
        this.classUser = classUser;
    }
}
