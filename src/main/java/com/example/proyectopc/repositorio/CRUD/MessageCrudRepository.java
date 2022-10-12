package com.example.proyectopc.repositorio.CRUD;

import com.example.proyectopc.modelo.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
