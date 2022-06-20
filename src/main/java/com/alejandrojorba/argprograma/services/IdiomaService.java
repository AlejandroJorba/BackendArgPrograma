package com.alejandrojorba.argprograma.services;

import com.alejandrojorba.argprograma.entities.Idioma;
import com.alejandrojorba.argprograma.repository.IdiomaRepository;
import com.alejandrojorba.argprograma.services.interfaces.IIdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdiomaService implements IIdiomaService {

    @Autowired
    private IdiomaRepository idiomaRepository;


    @Override
    public List<Idioma> getAll() {
        return idiomaRepository.findAll();
    }

    @Override
    public void save(Idioma idioma) {
        idiomaRepository.save(idioma);
    }

    @Override
    public void delete(long id) {
        idiomaRepository.deleteById(id);
    }

    @Override
    public Idioma find(long id) {
        return idiomaRepository.findById(id).orElse(null);
    }
}
