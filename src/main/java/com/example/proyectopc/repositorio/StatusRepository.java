package com.example.proyectopc.repositorio;

import com.example.proyectopc.modelo.Score;
import com.example.proyectopc.modelo.Status;
import com.example.proyectopc.repositorio.CRUD.StatusCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StatusRepository {

    @Autowired
    private StatusCrudRepository statusCrudRepository;

    public List<Status> getAll(){
        return (List<Status>) statusCrudRepository.findAll();
    }
    public Optional<Status> getStatus(int id){
        return statusCrudRepository.findById(id);
    }
    public Status save(Status p){
        return statusCrudRepository.save(p);
    }
    public void delete(Status p){
        statusCrudRepository.delete(p);
    }

}
