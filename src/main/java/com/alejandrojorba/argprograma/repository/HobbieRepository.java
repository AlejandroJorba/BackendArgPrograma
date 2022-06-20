package com.alejandrojorba.argprograma.repository;

import com.alejandrojorba.argprograma.entities.Hobbie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HobbieRepository extends JpaRepository<Hobbie, Long> {
}
