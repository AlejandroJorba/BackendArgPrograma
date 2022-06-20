package com.alejandrojorba.argprograma.entities;


import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
public @Data class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "usuario")
    String usuario;
    @Column(name = "password")
    String password;
    @ManyToMany()
    List<Rol> rolList;
}
