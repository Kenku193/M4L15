package org.example.way1.step3.entity.employees;

import jakarta.persistence.*;
import org.example.way1.step3.entity.User;

import java.time.LocalDate;

@MappedSuperclass
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
