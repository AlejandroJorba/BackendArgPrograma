package com.alejandrojorba.argprograma.controller;

import com.alejandrojorba.argprograma.DTOs.AuthenticateRequest;
import com.alejandrojorba.argprograma.Security.JwtUtil;
import com.alejandrojorba.argprograma.entities.Response;
import com.alejandrojorba.argprograma.entities.Usuario;
import com.alejandrojorba.argprograma.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/usuario/getUsers")
    public ResponseEntity<Response> getUsuarios(){
        try {
           List<Usuario> usuarios = usuarioService.getAll();
           if(usuarios.size() <= 0) return new ResponseEntity<>(new Response(usuarios, "No se han encontrado resultados"), HttpStatus.NOT_FOUND);
           return new ResponseEntity<>(new Response(usuarios, "La búsqueda se ejecutó exitosamente"), HttpStatus.OK);
       }
       catch (Exception e) {
           return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping("/usuario/getUser/{id}")
    public ResponseEntity<Response> getUsuarioByID(@PathVariable long id){
        try{
            Usuario user = usuarioService.find(id);
            if(user == null) return new ResponseEntity<>(new Response(null, "No se han encontrado resultados"), HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(new Response(user, "La búsqueda se ejecutó exitosamente"), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/usuario/login")
    public ResponseEntity<Response> login(@RequestBody AuthenticateRequest usuario){
        try {
            Usuario user = usuarioService.login(usuario.getUsuario(), usuario.getPassword());
            if(user == null) return new ResponseEntity<>(new Response(null, "Los datos ingresados son incorrectos"), HttpStatus.NOT_FOUND);
            else {
                String jwt = jwtUtil.generateToken(user.getUsuario());
                return new ResponseEntity<>(new Response(jwt, "La búsqueda se ejecutó exitosamente"), HttpStatus.OK);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/usuario/addUser")
    public ResponseEntity<Response> addUsuario(@RequestBody Usuario usuario){
        try{
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String password = bCryptPasswordEncoder.encode(usuario.getPassword());
            usuario.setPassword(password);
            usuarioService.save(usuario);
            return new ResponseEntity<>(new Response<>(usuario, "El usuario se añadió exitosamente"), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/usuario/delete/{id}")
    public ResponseEntity<Response> deleteUsuario(@PathVariable long id){
        try {
            usuarioService.delete(id);
            return new ResponseEntity<>(new Response(id, "El registro fue eliminado exitosamente"), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new Response(null, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
