package org.example.way4.step1;

import org.example.way3.step1.entity.User;
import org.example.way4.step1.entity.clients.Client;
import org.example.way4.step1.entity.employees.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class Step1Runner {
    public static void main(String[] args) {

        // ДОБАВИЛ АННОТАЦИЮ @Inheritance(strategy = InheritanceType.JOINED) В САМЫЙ ВЕРХНИЙ КЛАСС
        // ТЕПЕРЬ ПОЛУЧУ ПО ТАБЛИЦЕ НА КАЖДЫЙ КЛАСС, НО В НИХ КОЛ-ВО ПОЛЕЙ ОТЛИЧАЕТСЯ ОТ ПРОШЛОГО ПРИМЕРА
        // ЗДЕСЬ МЫ НЕ УВИДИМ, НАПРМИЕР, В ТАБЛИЦЕ clients ПОЛЕ name ИЗ User
        // ПОТОМУ ЧТО ПО СВЯЗИ (ПРИМЕНИВ Join) ЭТО ДАННОЕ И ТАК МОЖНО ВЫТАЩИТЬ

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(org.example.way4.step1.entity.clients.Client.class)
                .addAnnotatedClass(org.example.way4.step1.entity.User.class)
                .addAnnotatedClass(org.example.way4.step1.entity.employees.Developer.class)
                .buildSessionFactory();

        org.example.way4.step1.entity.User user1 = new org.example.way4.step1.entity.User(12, "User1");
        org.example.way4.step1.entity.User user2 = new org.example.way4.step1.entity.User(22, "User2");

        org.example.way4.step1.entity.clients.Client client = new Client(401, "Bobby", "Boston", LocalDate.now());
        org.example.way4.step1.entity.employees.Developer developer = new Developer(555, "Steve", "Palo Alto", LocalDate.now());

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(user1);
            session.persist(user2);
            session.persist(client);
            session.persist(developer);
            session.getTransaction().commit();
        }

        // А ТЕПЕРЬ ИНТЕРЕСНО СОДЕРЖИМОЕ ТАБЛИЦЫ users - МЫ ПРЕДПОЛАГАЕМ ЧТО ТУДА ПОПАДУТ ТОЛЬКО user1 и user2?
        // ПО ФАКТУ ТАМ ОКАЖУТСЯ ВСЕ, ПОТОМУ ЧТО ВСЕ Entity ПОТОМКИ User
        // ПОЛУЧИЛИ НАБОР СВЯЗАННЫХ ТАБЛИЦ С НЕИЗБЫТОЧНЫМИ ДАННЫМИ, ОЧЕНЬ УДОБНО

        // ВЫТАСКИВАЕМ ИЗ БД СОДЕРЖИМОЕ КАК User, ПОТОМУ ЧТО ВСЕ ТОЧНО User
        // И УБЕЖДАЕМСЯ ЧТО Hibernate ПОНИМАЕТ ЧТО НА САМОМ ДЕЛЕ ЗА ОБЪЕКТЫ ОН БЕРЕТ
        // И ДАЖЕ ОБХОДИТСЯ БЕЗ DTYPE
        try (Session session = sessionFactory.openSession()){
            Query<org.example.way4.step1.entity.User> from_user_ = session.createQuery("from User ", org.example.way4.step1.entity.User.class);

            List<org.example.way4.step1.entity.User> list = from_user_.list();
            for (org.example.way4.step1.entity.User user : list) {
                System.out.println(user);
            }
        }

    }
}
