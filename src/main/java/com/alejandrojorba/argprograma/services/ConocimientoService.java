package com.alejandrojorba.argprograma.services;

import com.alejandrojorba.argprograma.entities.Conocimiento;
import com.alejandrojorba.argprograma.repository.ConocimientoRepository;
import com.alejandrojorba.argprograma.services.interfaces.IConocimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConocimientoService implements IConocimientoService {

    @Autowired
    private ConocimientoRepository conocimientoRepository;


    @Override
    public List<Conocimiento> getAll() {
        return conocimientoRepository.findAll();
    }

    @Override
    public void save(Conocimiento entidad) {
        conocimientoRepository.save(entidad);
    }

    @Override
    public void delete(long id) {
        conocimientoRepository.deleteById(id);
    }

    @Override
    public Conocimiento find(long id) {
        return conocimientoRepository.findById(id).orElse(null);
    }
}
