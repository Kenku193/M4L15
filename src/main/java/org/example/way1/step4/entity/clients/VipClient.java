package org.example.way1.step4.entity.clients;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "vip_clients")
public class VipClient extends Client {

    @Column(name = "tax_number")
    private int taxNumber;
    @Column(name = "birthday")
    private LocalDate birthday;

    public VipClient() {
    }

    public VipClient(int id, String name, String address, LocalDate clientFrom, int taxNumber, LocalDate birthday) {
        super(id, name, address, clientFrom);
        this.taxNumber = taxNumber;
        this.birthday = birthday;
    }
}
