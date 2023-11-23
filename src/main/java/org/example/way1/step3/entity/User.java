package org.example.way1.step3.entity;

import jakarta.persistence.*;

@MappedSuperclass
public class User {

    private int id;
    @Column(name = "name")
    private String name;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
