package com.zuk.javatask;

import com.zuk.javatask.entity.Person;
import com.zuk.javatask.entity.Role;
import com.zuk.javatask.util.DefaultUser;
import com.zuk.javatask.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.util.List;

@Slf4j
@SpringBootApplication
public class JavataskApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavataskApplication.class, args);
    }

}
