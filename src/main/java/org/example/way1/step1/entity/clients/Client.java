package org.example.way1.step1.entity.clients;

import org.example.way1.step1.entity.User;

import java.time.LocalDate;
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
