package com.alejandrojorba.argprograma.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
public @Data class Hobbie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "nombre")
    String nombreHobbie;
    @ManyToOne
    Persona persona;
}
