package com.example.proyectopc.Controlador;


import com.example.proyectopc.Servicios.ComputerServices;
import com.example.proyectopc.modelo.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/Computer")
public class ComputerController {

    @Autowired
    private ComputerServices computerServices;

    @GetMapping("/all")
    public List<Computer> getAll(){
        return computerServices.getAll();

    }
    @GetMapping("/{id}")
    public Optional<Computer> getComputer(@PathVariable("id") int id){
        return computerServices.getComputer(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Computer save(@RequestBody Computer p){
        return computerServices.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Computer update(@RequestBody Computer p){
        return computerServices.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return computerServices.delete(id);
    }



}
