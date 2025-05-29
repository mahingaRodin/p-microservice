package com.pm.patientservice.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


}
