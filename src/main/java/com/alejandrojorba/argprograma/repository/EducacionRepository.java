package com.alejandrojorba.argprograma.repository;

import com.alejandrojorba.argprograma.entities.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Long> {
}
