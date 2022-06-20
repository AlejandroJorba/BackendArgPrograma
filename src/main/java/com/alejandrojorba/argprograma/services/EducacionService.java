package com.alejandrojorba.argprograma.services;

import com.alejandrojorba.argprograma.entities.Educacion;
import com.alejandrojorba.argprograma.repository.EducacionRepository;
import com.alejandrojorba.argprograma.services.interfaces.IEducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EducacionService implements IEducacionService {

    @Autowired
    private EducacionRepository educacionRepository;


    @Override
    public List<Educacion> getAll() {
        return educacionRepository.findAll();
    }

    @Override
    public void save(Educacion educacion) {
        educacionRepository.save(educacion);
    }

    @Override
    public void delete(long id) {
        educacionRepository.deleteById(id);
    }

    @Override
    public Educacion find(long id) {
        return educacionRepository.findById(id).orElse(null);
    }
}
