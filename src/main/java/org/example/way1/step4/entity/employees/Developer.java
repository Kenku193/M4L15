package org.example.way1.step4.entity.employees;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.example.way1.step4.entity.User;

import java.time.LocalDate;

@Entity
@Table(name = "developers")
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
