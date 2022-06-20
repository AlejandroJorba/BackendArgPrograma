package com.alejandrojorba.argprograma.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
public @Data class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre")
    private String nombre;

}
