package com.zuk.javatask.util;

import com.zuk.javatask.entity.Person;

import com.zuk.javatask.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class DefaultUser {

    @Autowired
    private final PersonService personService;

    @Autowired
    public DefaultUser(PersonService personService) {
        this.personService = personService;
    }


    @EventListener(ContextRefreshedEvent.class)
    private void createDefaultUsers(){
        personService.createDefaultUser();
    }
}

