package org.example.way1.step1;

import org.example.way1.step1.entity.clients.VipClient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class Step1Runner {
    public static void main(String[] args) {

        // ИМЕЕМ ТРИ Entity, ТОЛЬКО В ОДНОЙ ИЗ КОТОРЫХ ЕСТЬ JPA-АННОТАЦИИ
        // В ЕЕ РОДИТЕЛЬСКИХ КЛАССАХ НИЧЕГО НЕТ

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(VipClient.class)
                .buildSessionFactory();

        // JAVA
        VipClient vipClient = new VipClient(123, "Bruce Willis", "New York", LocalDate.now(), 7766, LocalDate.now());

        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.persist(vipClient);
            // RELATION MODEL
            session.getTransaction().commit();
        }

    }
}
