package com.alejandrojorba.argprograma.controller;

import com.alejandrojorba.argprograma.entities.Idioma;
import com.alejandrojorba.argprograma.entities.Response;
import com.alejandrojorba.argprograma.services.IdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IdiomaController {
    @Autowired
    IdiomaService idiomaService;

    @GetMapping("/idioma/getIdiomas")
    public ResponseEntity<Response> getIdiomas() {
        try {
            List<Idioma> idiomaList = idiomaService.getAll();
            if (idiomaList.size() <= 0) return new ResponseEntity<>(new Response(idiomaList, "No se han encontrado resultados"), HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(new Response(idiomaList, "La búsqueda se ejecutó exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/idioma/addIdioma")
    public ResponseEntity<Response> addIdioma(@RequestBody Idioma idioma) {
        try {
            idiomaService.save(idioma);
            return new ResponseEntity<>(new Response(idioma, "El idioma se añadió exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/idioma/getIdioma/{id}")
    public ResponseEntity<Response> getIdiomaByID(@PathVariable long id) {
        try {
            Idioma idioma = idiomaService.find(id);
            if (idioma == null) return new ResponseEntity<>(new Response(null, "No se han encontrado resultados"), HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(new Response(idioma, "La búsqueda se ejecutó exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/idioma/delete/{id}")
    public ResponseEntity<Response> deleteIdioma(@PathVariable long id) {
        try {
            idiomaService.delete(id);
            return new ResponseEntity<>(new Response(id, "El registro fue eliminado exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
