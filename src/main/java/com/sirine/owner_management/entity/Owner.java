package com.sirine.owner_management.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Entity
@Data
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private String cin;

    private Date dateBirth;

    private String gender;

    private String address;

    @OneToMany(mappedBy = "owner") // Relation One-to-Many avec Contact
    private List<Contact> contacts;

    @OneToMany(mappedBy = "owner") // Relation One-to-Many avec Unit
    private List<Unit> units;
}
