package com.alejandrojorba.argprograma.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
public @Data class Idioma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "idioma")
    String idioma;
    @Column(name = "nivel")
    String nivel;
    @ManyToOne
    Persona persona;
}
