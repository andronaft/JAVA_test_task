package com.zuk.javatask.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person_roles")
@Data
public class PersonRoles {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "person_id")
    private Long personId;

    @Column(name = "role_id")
    private Long roleId;
}
