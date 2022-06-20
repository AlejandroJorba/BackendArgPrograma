package com.alejandrojorba.argprograma.repository;

import com.alejandrojorba.argprograma.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
}
