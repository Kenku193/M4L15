package org.example.way2.step1.entity.clients;

import jakarta.persistence.*;
import org.example.way2.step1.entity.User;

import java.time.LocalDate;
@Entity
@Table(name = "users_andClients_andDevs")
public class Client extends User {
    @Column(name = "address")
    private String address;
    @Column(name = "clientFrom")
    private LocalDate clientFrom;
    public Client() {
    }
    public Client(int id, String name, String address, LocalDate clientFrom) {
        super(id, name);
        this.address = address;
        this.clientFrom = clientFrom;
    }
}
