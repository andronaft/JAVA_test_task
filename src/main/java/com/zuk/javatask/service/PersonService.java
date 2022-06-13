package com.zuk.javatask.service;

import com.zuk.javatask.entity.Person;
import org.springframework.data.domain.Page;

public interface PersonService {
    Person findByUsername(String username);
    Person createUser(Person person);
    Page<Person> findAll();

    void createDefaultUser();
}
