package org.example.way2.step1.entity;

import jakarta.persistence.*;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Table(name = "users_andClients_andDevs")
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
