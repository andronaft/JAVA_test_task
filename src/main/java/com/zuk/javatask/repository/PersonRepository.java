package com.zuk.javatask.repository;

import com.zuk.javatask.entity.Person;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
    Person findByUsername(String username);
    Page<Person> findAll(Pageable pageable);

}
