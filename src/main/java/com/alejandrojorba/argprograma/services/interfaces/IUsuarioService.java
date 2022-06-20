package com.alejandrojorba.argprograma.services.interfaces;


import com.alejandrojorba.argprograma.entities.Usuario;

public interface IUsuarioService extends IBaseService<Usuario> {

    public Usuario login(String usuario, String password);
    public Usuario user(String usuario);

}
