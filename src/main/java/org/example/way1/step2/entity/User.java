package org.example.way1.step2.entity;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class User {
    private int id;
    private String name;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
