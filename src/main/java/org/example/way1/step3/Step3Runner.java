package org.example.way1.step3;

import org.example.way1.step3.entity.User;
import org.example.way1.step3.entity.clients.Client;
import org.example.way1.step3.entity.clients.VipClient;
import org.example.way1.step3.entity.employees.Developer;
import org.example.way1.step3.entity.employees.Teamlead;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class Step3Runner {
    public static void main(String[] args) {

        // ПРИМЕР С ДВУМЯ ВЕТВЯМИ НАСЛЕДОВАНИЯ И @MappedSuperclass В РОДИТЕЛЯХ
        // ПОЯВЛЯЮТЯ ТАБЛИЦЫ В СООТВЕТСТВИИ С ВЕТВЯМИ НАСЛЕДОВАНИЯ

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(VipClient.class)
                .addAnnotatedClass(Teamlead.class)
                .addAnnotatedClass(Developer.class)
                .buildSessionFactory();


        VipClient vipClient = new VipClient(123, "Bruce Willis", "New York", LocalDate.now(), 7766, LocalDate.now());

        Teamlead teamlead = new Teamlead(667, "Mike", "LA", LocalDate.now(), 9110, LocalDate.now());

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(vipClient);
            session.persist(teamlead);
            session.getTransaction().commit();
        }

    }
}
