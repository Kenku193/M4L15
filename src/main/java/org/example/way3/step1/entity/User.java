package org.example.way3.step1.entity;

import jakarta.persistence.*;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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
