package com.example.proyectopc.Controlador;


import com.example.proyectopc.Servicios.CategoryServices;
import com.example.proyectopc.Servicios.ComputerServices;
import com.example.proyectopc.modelo.Category;
import com.example.proyectopc.modelo.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/Category")
public class CategoryController {

    @Autowired
    private CategoryServices categoryServices;

    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryServices.getAll();

    }
    @GetMapping("/{id}")
    public Optional<Category> getComputer(@PathVariable("id") int id){
        return categoryServices.getCategory(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category p){
        return categoryServices.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category p){
        return categoryServices.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return categoryServices.delete(id);
    }



}
