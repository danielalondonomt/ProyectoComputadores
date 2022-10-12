package com.example.proyectopc.Controlador;


import com.example.proyectopc.Servicios.StatusServices;
import com.example.proyectopc.modelo.Score;
import com.example.proyectopc.modelo.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/Status")
public class StatusController {

    @Autowired
    private StatusServices statusServices;

    @GetMapping("/all")
    public List<Status> getAll(){
        return statusServices.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Status> getStatus(@PathVariable("id") int id){
        return statusServices.getStatus(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Status save(@RequestBody Status p){
        return statusServices.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Status update(@RequestBody Status p){
        return statusServices.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return statusServices.delete(id);
    }



}
