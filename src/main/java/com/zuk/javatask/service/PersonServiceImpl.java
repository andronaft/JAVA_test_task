package com.zuk.javatask.service;

import com.zuk.javatask.entity.Person;
import com.zuk.javatask.entity.Role;
import com.zuk.javatask.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;


@Service
@Slf4j
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, BCryptPasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Person findByUsername(String username) {
        return personRepository.findByUsername(username);
    }

    @Override
    public Person createUser(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        return personRepository.save(person);
    }

    @Override
    public Page<Person> findAll() {
        Pageable pageable = PageRequest.of(0, 5);
        return personRepository.findAll(pageable);
    }

    @Override
    public void createDefaultUser() {
        Person admin = new Person();
        admin.setPassword(passwordEncoder.encode("pyssword"));
        admin.setRole(Role.ADMIN);
        admin.setUsername("zhuk");
        admin.setAge(12);
        admin.setPhone("+380000000");
        admin.setEmail("zhuk@zhuk.com");
        admin.setBirthday(Timestamp.valueOf("2007-09-23 10:10:10.0"));

        personRepository.save(admin);

        Person guest = new Person();
        guest.setPassword(passwordEncoder.encode("guest"));
        guest.setRole(Role.GUEST);
        guest.setUsername("guest");
        guest.setAge(12);
        guest.setPhone("+3811111111");
        guest.setEmail("guest@zhuk.com");
        guest.setBirthday(Timestamp.valueOf("2007-09-23 10:10:10.0"));

        personRepository.save(guest);

    }
}
