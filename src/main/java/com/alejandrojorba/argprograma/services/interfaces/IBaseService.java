package com.alejandrojorba.argprograma.services.interfaces;

import com.alejandrojorba.argprograma.entities.Conocimiento;

import java.util.List;

public interface IBaseService<E> {

    public List<E> getAll();
    public void save(E entidad);
    public void delete(long id);
    public E find(long id);

}
