package com.example.proyectopc.Controlador;


import com.example.proyectopc.Servicios.AdminServices;
import com.example.proyectopc.modelo.Admin;
import com.example.proyectopc.modelo.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/Admin")
public class AdminController {

    @Autowired
    private AdminServices adminServices;

    @GetMapping("/all")
    public List<Admin> getAll() {
        return adminServices.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id") int id) {
        return adminServices.getAdmin(id);}

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save (@RequestBody Admin p){
        return adminServices.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin p){
        return adminServices.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return adminServices.delete(id);
    }


}