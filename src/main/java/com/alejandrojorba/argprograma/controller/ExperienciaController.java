package com.alejandrojorba.argprograma.controller;

import com.alejandrojorba.argprograma.entities.Experiencia;
import com.alejandrojorba.argprograma.entities.Response;
import com.alejandrojorba.argprograma.services.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExperienciaController {

    @Autowired
    ExperienciaService experienciaService;

    @GetMapping("/experiencia/getExperiencias")
    public ResponseEntity<Response> getExperiencias() {
        try {
            List<Experiencia> experienciaList = experienciaService.getAll();
            if (experienciaList.size() <= 0) return new ResponseEntity<>(new Response(experienciaList, "No se han encontrado resultados"), HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(new Response(experienciaList, "La búsqueda se ejecutó exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/experiencia/addExperiencia")
    public ResponseEntity<Response> addExperiencia(@RequestBody Experiencia experiencia) {
        try {
            experienciaService.save(experiencia);
            return new ResponseEntity<>(new Response(experiencia, "La experiencia se añadió exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/experiencia/getExperiencia/{id}")
    public ResponseEntity<Response> getExperienciaById(@PathVariable long id) {
        try {
            Experiencia experiencia = experienciaService.find(id);
            if (experiencia == null) return new ResponseEntity<>(new Response(null, "No se han encontrado resultados"), HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(new Response(experiencia, "La búsqueda se ejecutó exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/experiencia/delete/{id}")
    public ResponseEntity<Response> deleteExperiencia(@PathVariable long id) {
        try {
            experienciaService.delete(id);
            return new ResponseEntity<>(new Response(id, "El registro fue eliminado exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
