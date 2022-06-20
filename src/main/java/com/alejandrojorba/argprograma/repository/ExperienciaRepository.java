package com.alejandrojorba.argprograma.repository;

import com.alejandrojorba.argprograma.entities.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {

}
