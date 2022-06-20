package com.alejandrojorba.argprograma.repository;

import com.alejandrojorba.argprograma.entities.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdiomaRepository extends JpaRepository<Idioma, Long> {
}
