package com.alejandrojorba.argprograma.services;

import com.alejandrojorba.argprograma.entities.Rol;
import com.alejandrojorba.argprograma.repository.RolRepository;
import com.alejandrojorba.argprograma.services.interfaces.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService implements IRolService {

    @Autowired
    private RolRepository rolRepository;


    @Override
    public List<Rol> getAll() {
        return rolRepository.findAll();
    }

    @Override
    public void save(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public void delete(long id) {
        rolRepository.deleteById(id);
    }

    @Override
    public Rol find(long id) {
        return rolRepository.findById(id).orElse(null);
    }
}
