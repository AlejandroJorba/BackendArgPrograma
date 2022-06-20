package com.alejandrojorba.argprograma.services;

import com.alejandrojorba.argprograma.entities.Experiencia;
import com.alejandrojorba.argprograma.repository.ExperienciaRepository;
import com.alejandrojorba.argprograma.services.interfaces.IExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaService implements IExperienciaService {

    @Autowired
    private ExperienciaRepository experienciaRepository;


    @Override
    public List<Experiencia> getAll() {
        return experienciaRepository.findAll();
    }

    @Override
    public void save(Experiencia experiencia) {
            experienciaRepository.save(experiencia);
    }

    @Override
    public void delete(long id) {
        experienciaRepository.deleteById(id);
    }

    @Override
    public Experiencia find(long id) {
        return experienciaRepository.findById(id).orElse(null);
    }
}
