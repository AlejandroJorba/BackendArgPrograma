package com.alejandrojorba.argprograma.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
public @Data class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "imagen")
    String imagenInstitucion;
    @Column(name = "nombre")
    String nombreInstitucion;
    @Column(name = "titulacion")
    String titulacion;
    @Column(name = "descripcion")
    String descripcion;
    @Column(name = "desde")
    Date desde;
    @Column(name = "hasta")
    Date hasta;
    @ManyToOne
    Persona persona;

}
