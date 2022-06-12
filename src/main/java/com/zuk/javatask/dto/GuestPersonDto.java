package com.zuk.javatask.dto;

import com.zuk.javatask.entity.Person;
import lombok.Data;

@Data
public class GuestPersonDto {

    private String name;
    private String surname;
    private Integer age;

    public GuestPersonDto toGuestPersonDto(Person person) {
        GuestPersonDto guestPersonDto = new GuestPersonDto();
        guestPersonDto.setAge(person.getAge());
        guestPersonDto.setName(person.getName());
        guestPersonDto.setSurname(person.getSurname());

        return guestPersonDto;
    }

}
