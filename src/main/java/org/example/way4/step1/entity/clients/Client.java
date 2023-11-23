package org.example.way4.step1.entity.clients;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.example.way4.step1.entity.User;

import java.time.LocalDate;
@Entity
@Table(name = "clients")
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
