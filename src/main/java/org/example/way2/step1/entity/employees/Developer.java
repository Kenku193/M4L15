package org.example.way2.step1.entity.employees;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.example.way2.step1.entity.User;

import java.time.LocalDate;

@Entity
@Table(name = "users_andClients_andDevs")
public class Developer extends User {
    @Column(name = "address")
    private String address;
    @Column(name = "clientFrom")
    private LocalDate clientFrom;
    public Developer() {
    }
    public Developer(int id, String name, String address, LocalDate clientFrom) {
        super(id, name);
        this.address = address;
        this.clientFrom = clientFrom;
    }

}
