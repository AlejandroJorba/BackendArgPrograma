package com.alejandrojorba.argprograma.entities;

import lombok.Cleanup;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
public @Data class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "nombre")
    String nombre;
    @Column(name = "apellido")
    String apellido;
    @OneToOne
    Usuario usuario;
}
