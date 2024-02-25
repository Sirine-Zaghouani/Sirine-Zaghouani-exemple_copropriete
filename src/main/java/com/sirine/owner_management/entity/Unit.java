package com.sirine.owner_management.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String unitName;
    private int floorArea;
    private String emplacement ;
    private int numberRooms;
    private Date dateAdded;
    private String block;

    @ManyToOne // Relation Many-to-One avec Owner
    private Owner owner;

}
