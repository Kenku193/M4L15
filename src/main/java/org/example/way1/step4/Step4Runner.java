package org.example.way1.step4;

import org.example.way1.step4.entity.User;
import org.example.way1.step4.entity.clients.Client;
import org.example.way1.step4.entity.clients.VipClient;
import org.example.way1.step4.entity.employees.Developer;
import org.example.way1.step4.entity.employees.Teamlead;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class Step4Runner {
    public static void main(String[] args) {

        // УБРАЛ АННОТАЦИЮ @MappedSuperclass ИЗ КЛАССОВ-РОДИТЕЛЕЙ
        // ДОБАВИЛ АННОТАЦИЮ @Entity В КЛАССЫ-РОДИТЕЛИ
        // ПРИ ЭТОМ ВСЕ ПОЛЯ ВСЕ ЕЩЕ СОХРАНЯЮТСЯ В ОДНУ ОБЩУЮ ТАБЛИЦУ

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(VipClient.class)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Developer.class)
                .addAnnotatedClass(Teamlead.class)
                .buildSessionFactory();

        User user1 = new User(12, "User1");
        User user2 = new User(22, "User2");
        User user3 = new User(32, "User3");

        Client client1 = new Client(401, "Bobby", "Boston", LocalDate.now());
        Client client2 = new Client(402, "Marley", "Forks", LocalDate.now());

        VipClient vipClient = new VipClient(123, "Bruce Willis", "New York", LocalDate.now(), 7766, LocalDate.now());

        Developer developer = new Developer(555, "Steve", "Palo Alto", LocalDate.now());
        Teamlead teamlead = new Teamlead(667, "Mike", "LA", LocalDate.now(), 9110, LocalDate.now());

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(user1);
            session.persist(user2);
            session.persist(user3);
            session.persist(client1);
            session.persist(client2);
            session.persist(vipClient);

            session.persist(developer);
            session.persist(teamlead);

            session.getTransaction().commit();
        }

    }
}
