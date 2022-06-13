package com.zuk.javatask.controller;


import com.zuk.javatask.dto.AdminPersonDto;
import com.zuk.javatask.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/admin/person/")
@Slf4j
public class AdminController {

    private final PersonService personService;

    @Autowired
    public AdminController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("create")
    public ResponseEntity create(@RequestBody AdminPersonDto personDto) {
        log.info("here");
        return ResponseEntity.ok(personService.createUser(personDto.toPerson()));
    }
}
