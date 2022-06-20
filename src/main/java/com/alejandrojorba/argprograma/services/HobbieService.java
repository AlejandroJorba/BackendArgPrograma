package com.alejandrojorba.argprograma.services;

import com.alejandrojorba.argprograma.entities.Hobbie;
import com.alejandrojorba.argprograma.repository.HobbieRepository;
import com.alejandrojorba.argprograma.services.interfaces.IHobbieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbieService implements IHobbieService {

    @Autowired
    private HobbieRepository hobbieRepository;


    @Override
    public List<Hobbie> getAll() {
        return hobbieRepository.findAll();
    }

    @Override
    public void save(Hobbie hobbie) {
        hobbieRepository.save(hobbie);
    }

    @Override
    public void delete(long id) {
        hobbieRepository.deleteById(id);
    }

    @Override
    public Hobbie find(long id) {
        return hobbieRepository.findById(id).orElse(null);
    }
}
