package org.example.way1.step2.entity.clients;

import jakarta.persistence.MappedSuperclass;
import org.example.way1.step2.entity.User;

import java.time.LocalDate;
@MappedSuperclass
public class Client extends User {
    private String address;
    private LocalDate clientFrom;
    public Client() {
    }
    public Client(int id, String name, String address, LocalDate clientFrom) {
        super(id, name);
        this.address = address;
        this.clientFrom = clientFrom;
    }
}
