package org.example.way4.step1.entity;

import jakarta.persistence.*;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "users")
public class User {
    @Id
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
