package com.alejandrojorba.argprograma.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
public @Data class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "posicion")
    String posicion;
    @Column(name = "nombre")
    String nombreEmpresa;
    @Column(name = "descripcion")
    String descripcion;
    @Column(name = "antiguedad")
    String antiguedad;
    @Column(name = "imagen")
    String imagenEmpresa;
    @Column(name = "desde")
    Date desde;
    @Column(name = "hasta")
    Date hasta;
    @ManyToOne
    Persona persona;
}
