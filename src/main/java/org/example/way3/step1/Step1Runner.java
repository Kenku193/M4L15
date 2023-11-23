package org.example.way3.step1;

import org.example.way3.step1.entity.User;
import org.example.way3.step1.entity.clients.Client;
import org.example.way3.step1.entity.employees.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class Step1Runner {
    public static void main(String[] args) {

        // ДОБАВИЛ АННОТАЦИЮ @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) В САМЫЙ ВЕРХНИЙ КЛАСС
        // ТЕПЕРЬ ПОЛУЧУ ПО ТАБЛИЦЕ НА КАЖДЫЙ КЛАСС

        // ЕСЛИ ЕСТЬ ВЛОЖЕННОСТЬ ЕЩЕ ГЛУБЖЕ - ПРОСТО СТАВИМ В КАЖДОМ ПРЕДКЕ

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Developer.class)
                .buildSessionFactory();

        User user1 = new User(12, "User1");
        User user2 = new User(22, "User2");

        Client client = new Client(401, "Bobby", "Boston", LocalDate.now());
        Developer developer = new Developer(555, "Steve", "Palo Alto", LocalDate.now());

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(user1);
            session.persist(user2);
            session.persist(client);
            session.persist(developer);
            session.getTransaction().commit();
        }

        // ВЫТАСКИВАЕМ ИЗ БД СОДЕРЖИМОЕ КАК User, ПОТОМУ ЧТО ВСЕ ТОЧНО User
        // И УБЕЖДАЕМСЯ ЧТО Hibernate ПОНИМАЕТ ЧТО НА САМОМ ДЕЛЕ ЗА ОБЪЕКТЫ ОН БЕРЕТ

        // ЕСЛИ ПРИНУДИТЕЛЬНО В ТАБЛИЦЕ В ПОЛЕ DTYPE ВСЕХ СДЕЛАТЬ User - ЧТО ПРОИЗОЙДЕТ?
        // Hibernate УВИДИТ ВСЕХ КАК User, ПОЭТОМУ DTYPE КОНКРЕТИЗИРУЕТ ТИПЫ И КРИТИЧЕСКИ ВАЖЕН

        try (Session session = sessionFactory.openSession()){
            Query<org.example.way3.step1.entity.User> from_user_ = session.createQuery("from User ", org.example.way3.step1.entity.User.class);

            List<org.example.way3.step1.entity.User> list = from_user_.list();
            for (org.example.way3.step1.entity.User user : list) {
                System.out.println(user);
            }
        }

    }
}
