package com.alejandrojorba.argprograma.controller;

import com.alejandrojorba.argprograma.entities.Response;
import com.alejandrojorba.argprograma.entities.Rol;
import com.alejandrojorba.argprograma.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/rol/getRoles")
    public ResponseEntity<Response> getRoles() {
        try {
            List<Rol> roles = rolService.getAll();
            if (roles.size() <= 0) return new ResponseEntity<>(new Response(roles, "No se han encontrado resultados"), HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(new Response(roles, "La búsqueda se ejecutó exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/role/addRol")
    public ResponseEntity<Response> addRol(@RequestBody Rol rol) {
        try {
            rolService.save(rol);
            return new ResponseEntity<>(new Response(rol, "El rol se añadió exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/role/getRol/{id}")
    public ResponseEntity<Response> getRolByID(@PathVariable long id) {
        try {
            Rol rol = rolService.find(id);
            if (rol == null) return new ResponseEntity<>(new Response(null, "No se han encontrado resultados"), HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(new Response(rol, "La búsqueda se ejecutó exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/role/delete/{id}")
    public ResponseEntity<Response> deleteRol(@PathVariable long id) {
        try {
            rolService.delete(id);
            return new ResponseEntity<>(new Response(id, "El registro fue eliminado exitosamente"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
