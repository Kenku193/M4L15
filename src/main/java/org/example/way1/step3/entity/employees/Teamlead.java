package org.example.way1.step3.entity.employees;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "teamleads")
public class Teamlead extends Developer {
    @Id
    @Column(name = "tax_number")
    private int taxNumber;
    @Column(name = "birthday")
    private LocalDate birthday;

    public Teamlead() {
    }

    public Teamlead(int id, String name, String address, LocalDate clientFrom, int taxNumber, LocalDate birthday) {
        super(id, name, address, clientFrom);
        this.taxNumber = taxNumber;
        this.birthday = birthday;
    }
}
