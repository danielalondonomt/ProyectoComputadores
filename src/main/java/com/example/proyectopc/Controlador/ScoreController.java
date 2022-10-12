package com.example.proyectopc.Controlador;


import com.example.proyectopc.Servicios.ScoreServices;
import com.example.proyectopc.modelo.Message;
import com.example.proyectopc.modelo.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/Score")
public class ScoreController {

    @Autowired
    private ScoreServices scoreServices;

    @GetMapping("/all")
    public List<Score> getAll(){
        return scoreServices.getAll();

    }
    @GetMapping("/{id}")
    public Optional<Score> getScore(@PathVariable("id") int id){
        return scoreServices.getScore(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score p){
        return scoreServices.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update(@RequestBody Score p){
        return scoreServices.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return scoreServices.delete(id);
    }



}
