package com.example.proyectopc.repositorio;

import com.example.proyectopc.modelo.Category;
import com.example.proyectopc.modelo.Computer;
import com.example.proyectopc.repositorio.CRUD.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }
    public Optional<Category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    }
    public Category save(Category p){
        return categoryCrudRepository.save(p);
    }
    public void delete(Category p){
        categoryCrudRepository.delete(p);
    }

}
