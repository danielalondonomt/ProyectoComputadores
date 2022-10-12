package com.example.proyectopc.repositorio.CRUD;

import com.example.proyectopc.modelo.Score;
import com.example.proyectopc.modelo.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusCrudRepository extends CrudRepository<Status, Integer> {
}
