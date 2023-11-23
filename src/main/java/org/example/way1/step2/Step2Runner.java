package org.example.way1.step2;

import org.example.way1.step2.entity.clients.VipClient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class Step2Runner {
    public static void main(String[] args) {

        // ДОБАВИЛИ АННОТАЦИЮ @MappedSuperclass В КЛАССЫ-РОДИТЕЛИ
        // МОЖНО ДОБАВИТЬ ЕЕ НЕ ВО ВСЕ РОДИТЕЛИ, ТОГДА В БД ПОЛЕТЯТ ТОЛЬКО ТЕ ПОЛЯ
        // В КЛАССАХ КОТОРЫХ ЭТА АННОТАЦИЯ ЕСТЬ

        // ПРИ ЭТОМ ВСЕ ПОЛЯ СОХРАНЯЮТСЯ В ОДНУ ОБЩУЮ ТАБЛИЦУ - ЧТО-ТО НАПОМИНАЕТ?

        // ГДЕ ТЕПЕРЬ @Id?

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(VipClient.class)
                .buildSessionFactory();

        VipClient vipClient = new VipClient(123, "Bruce Willis", "New York", LocalDate.now(), 7766, LocalDate.now());

        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.persist(vipClient);
            session.getTransaction().commit();
        }

    }
}
