package com.alejandrojorba.argprograma.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
public @Data class Conocimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "nombre")
    String nombre;
    @Column(name = "antiguedad")
    String antiguedad;
    @ManyToOne
    Persona persona;

}
