package com.alejandrojorba.argprograma.services;

import com.alejandrojorba.argprograma.entities.Usuario;
import com.alejandrojorba.argprograma.repository.UsuarioRepository;
import com.alejandrojorba.argprograma.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public List<Usuario> getAll() {

        return usuarioRepository.findAll();
    }

    @Transactional()
    @Override
    public void save(Usuario entidad) {
        usuarioRepository.save(entidad);
        usuarioRepository.flush();
    }

    @Transactional()
    @Override
    public void delete(long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario find(long id) {
        return usuarioRepository.findById(id).orElse(null);
    }
    @Override
    public Usuario login(String usuario, String password) {
        Usuario user = usuarioRepository.findByUsuario(usuario);
        BCryptPasswordEncoder decoder = new BCryptPasswordEncoder();
        if(decoder.matches(password, user.getPassword())) return user;
        else return null;
    }

    @Override
    public Usuario user(String usuario) {
       Usuario user = usuarioRepository.findByUsuario(usuario);
        if(user != null) return user;
        return null;
    }
}
