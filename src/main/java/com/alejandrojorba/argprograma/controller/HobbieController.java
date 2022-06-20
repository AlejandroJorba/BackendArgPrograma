package com.alejandrojorba.argprograma.controller;

import com.alejandrojorba.argprograma.entities.Hobbie;
import com.alejandrojorba.argprograma.entities.Response;
import com.alejandrojorba.argprograma.services.HobbieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HobbieController {

    @Autowired
    HobbieService hobbieService;

    @GetMapping("/hobbie/getHobbies")
    public ResponseEntity<Response> getHobbies() {
        try {
            List<Hobbie> hobbieList = hobbieService.getAll();
            if (hobbieList.size() <= 0) return new ResponseEntity<>(new Response(hobbieList, "No se han encontrado resultados"), HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(new Response(hobbieList, "La búsqueda se ejecutó exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/hobbie/addHobbie")
    public ResponseEntity<Response> addHobbies(@RequestBody Hobbie hobbie) {
        try {
            hobbieService.save(hobbie);
            return new ResponseEntity<>(new Response(hobbie, "El hobbie se añadió exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/hobbie/getHobbie/{id}")
    public ResponseEntity<Response> getHobbieByID(@PathVariable long id) {
        try {
            Hobbie hobbie = hobbieService.find(id);
            if (hobbie == null) return new ResponseEntity<>(new Response(null, "No se han encontrado resultados"), HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(new Response(hobbie, "La búsqueda se ejecutó exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/hobbie/delete/{id}")
    public ResponseEntity<Response> deleteHobbie(@PathVariable long id) {
        try {
            hobbieService.delete(id);
            return new ResponseEntity<>(new Response(id, "El registro fue eliminado exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
