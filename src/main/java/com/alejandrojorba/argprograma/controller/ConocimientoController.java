package com.alejandrojorba.argprograma.controller;

import com.alejandrojorba.argprograma.entities.Conocimiento;
import com.alejandrojorba.argprograma.entities.Response;
import com.alejandrojorba.argprograma.services.ConocimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConocimientoController {
    @Autowired
    private ConocimientoService conocimientoService;

    @GetMapping("/conocimiento/getConocimientos")
    public ResponseEntity<Response> getConocimientos() {
        try {
            List<Conocimiento> conocimientoList = conocimientoService.getAll();
            if (conocimientoList.size() <= 0) return new ResponseEntity<>(new Response(conocimientoList, "No se han encontrado resultados"), HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(new Response(conocimientoList, "La búsqueda se ejecutó exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/conocimiento/addConocimiento")
    public ResponseEntity<Response> addConocimiento(@RequestBody Conocimiento conocimiento) {
        try {
            conocimientoService.save(conocimiento);
            return new ResponseEntity<>(new Response(conocimiento, "El conocimiento se añadió exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/conocimiento/getConocimiento/{id}")
    public ResponseEntity<Response> getConocimientoById(@PathVariable long id) {
        try {
            Conocimiento conocimiento = conocimientoService.find(id);
            if (conocimiento == null) return new ResponseEntity<>(new Response(null, "No se han encontrado resultados"), HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(new Response(conocimiento, "La búsqueda se ejecutó exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/conocimiento/delete/{id}")
    public ResponseEntity<Response> deleteConocimiento(@PathVariable long id) {
        try {
            conocimientoService.delete(id);
            return new ResponseEntity<>(new Response(id, "El registro fue eliminado exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
