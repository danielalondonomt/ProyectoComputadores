package com.example.proyectopc.repositorio.CRUD;

import com.example.proyectopc.modelo.Message;
import com.example.proyectopc.modelo.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreCrudRepository extends CrudRepository<Score, Integer> {
}
