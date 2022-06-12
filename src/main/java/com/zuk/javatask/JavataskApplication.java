package com.zuk.javatask;

import com.zuk.javatask.entity.Person;
import com.zuk.javatask.entity.Role;
import com.zuk.javatask.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.util.List;

@Slf4j
@SpringBootApplication
public class JavataskApplication {



    public static void main(String[] args) {

        SpringApplication.run(JavataskApplication.class, args);

        Person admin = new Person("andrii","zhuk", "zuk@zhuk.mail", "+380000000", Timestamp.valueOf("2007-09-23 10:10:10.0"), 12, "zhuk","pyssword", Role.ADMIN);
        Person guest = new Person("guest","guest", "guest@zhuk.mail", "+381111111", Timestamp.valueOf("2007-09-23 10:10:10.0"), 12, "guest","guest", Role.GUEST);


        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(admin);
            session.save(guest);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List< Person > personList = session.createQuery("from Person ", Person.class).list();
            log.info(personList.toString());
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

}
