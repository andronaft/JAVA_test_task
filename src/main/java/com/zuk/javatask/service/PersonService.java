package com.zuk.javatask.service;

import com.zuk.javatask.entity.Person;

public interface PersonService {
    Person findByUsername(String username);
}
