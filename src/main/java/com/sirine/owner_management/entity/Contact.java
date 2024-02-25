package com.sirine.owner_management.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long phoneNumber;

    private String email;

    @ManyToOne // Relation Many-to-One avec Owner
    private Owner owner;
}
