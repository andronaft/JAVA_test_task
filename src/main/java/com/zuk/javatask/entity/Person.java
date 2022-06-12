package com.zuk.javatask.entity;


import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Person")
@Data
public class Person {

    public Person() {

    }
    public Person(String name, String surname, String email, String phone, Timestamp birthday, Integer age, String username, String password,Role role) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.age = age;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email", unique=true)
    private String email;

    @Column(name = "phine", unique=true)
    private String phone;

    @Column(name = "birthday")
    private Timestamp birthday;

    @Column(name = "age")//not sure that it should be in db
    private Integer age;

    @Column(name = "username", unique=true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private Role role;

}

