package com.alejandrojorba.argprograma.services;

import com.alejandrojorba.argprograma.entities.Persona;
import com.alejandrojorba.argprograma.repository.PersonaRepository;
import com.alejandrojorba.argprograma.services.interfaces.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> getAll() {
        return personaRepository.findAll();
    }

    @Override
    public void save(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public void delete(long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona find(long id) {
        return personaRepository.findById(id).orElse(null);
    }
}
