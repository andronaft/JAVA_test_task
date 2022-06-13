package com.zuk.javatask.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zuk.javatask.entity.Person;
import com.zuk.javatask.entity.Role;
import lombok.Data;

import java.sql.Timestamp;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminPersonDto {

    private String name;
    private String surname;
    private String email;
    private String phone;
    private Timestamp birthday;
    private Integer age;
    private String username;
    private String password;
    private Role role;

    public Person toPerson() {
        Person person = new Person();
        person.setName(name);
        person.setSurname(surname);
        person.setEmail(email);
        person.setPhone(phone);
        person.setBirthday(birthday);
        person.setAge(age);
        person.setUsername(username);
        person.setPassword(password);
        person.setRole(role);
        return person;
    }

    public AdminPersonDto toAdminDtoPerson(Person personn){
        AdminPersonDto person = new AdminPersonDto();
        person.setName(name);
        person.setSurname(surname);
        person.setEmail(email);
        person.setPhone(phone);
        person.setBirthday(birthday);
        person.setAge(age);
        person.setUsername(username);
        person.setPassword(password);
        person.setRole(role);
        return person;
    }
}
