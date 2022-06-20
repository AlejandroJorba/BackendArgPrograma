package com.alejandrojorba.argprograma.controller;

import com.alejandrojorba.argprograma.entities.Educacion;
import com.alejandrojorba.argprograma.entities.Response;
import com.alejandrojorba.argprograma.services.EducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EducacionController {
    @Autowired
    private EducacionService educacionService;

    @GetMapping("/educacion/getEducaciones")
    public ResponseEntity<Response> getEducaciones() {
        try {
            List<Educacion> educacionList = educacionService.getAll();
            if (educacionList.size() <= 0) return new ResponseEntity<>(new Response(educacionList, "No se han encontrado resultados"), HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(new Response(educacionList, "La búsqueda se ejecutó exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/educacion/addEducacion")
    public ResponseEntity<Response> addEducacion(@RequestBody Educacion educacion) {
        try {
            educacionService.save(educacion);
            return new ResponseEntity<>(new Response(educacion, "La educación se añadió exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/educacion/getConocimiento/{id}")
    public ResponseEntity<Response> getEducacionByID(@PathVariable long id) {
        try {
            Educacion educacion = educacionService.find(id);
            if (educacion == null) return new ResponseEntity<>(new Response(null, "No se han encontrado resultados"), HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(new Response(educacion, "La búsqueda se ejecutó exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/educacion/delete/{id}")
    public ResponseEntity<Response> deleteEducacion(@PathVariable long id) {
        try {
            educacionService.delete(id);
            return new ResponseEntity<>(new Response(id, "El registro fue eliminado exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
