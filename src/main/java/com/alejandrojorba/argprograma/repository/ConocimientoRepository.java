package com.alejandrojorba.argprograma.repository;

import com.alejandrojorba.argprograma.entities.Conocimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConocimientoRepository extends JpaRepository<Conocimiento, Long> {
}
