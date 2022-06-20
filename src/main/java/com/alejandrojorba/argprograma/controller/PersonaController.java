package com.alejandrojorba.argprograma.controller;

import com.alejandrojorba.argprograma.entities.Persona;
import com.alejandrojorba.argprograma.entities.Response;
import com.alejandrojorba.argprograma.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    PersonaService personaService;
    UsuarioService usuarioService;
    HobbieService hobbieService;
    ExperienciaService experienciaService;
    EducacionService educacionService;
    ConocimientoService conocimientoService;
    IdiomaService idiomaService;
    RolService rolService;

    @GetMapping("/persona/getPersonas")
    public ResponseEntity<Response> getPersonas() {
        try {
            List<Persona> personaList = personaService.getAll();
            if (personaList.size() <= 0) return new ResponseEntity<>(new Response(personaList, "No se han encontrado resultados"), HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(new Response(personaList, "La búsqueda se ejecutó exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/persona/addPersona")
    public ResponseEntity<Response> addPersona(@RequestBody Persona persona) {
        try {
            personaService.save(persona);
            return new ResponseEntity<>(new Response(persona, "La persona se añadió exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/persona/getPersona/{id}")
    public ResponseEntity<Response> getPersonaByID(@PathVariable long id) {
        try {
            Persona persona = personaService.find(id);
            if (persona == null) return new ResponseEntity<>(new Response(null, "No se han encontrado resultados"), HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(new Response(persona, "La búsqueda se ejecutó exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/persona/delete/{id}")
    public ResponseEntity<Response> deletePersona(@PathVariable long id) {
        try {
            personaService.delete(id);
            return new ResponseEntity<>(new Response(id, "El registro fue eliminado exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
