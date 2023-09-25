package com.example.CRUD.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.CRUD.model.Empleado;

@Repository
public interface IEmpleado extends CrudRepository<Empleado, Integer>{

}
