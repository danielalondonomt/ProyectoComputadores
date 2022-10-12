package com.example.proyectopc.Servicios;

import com.example.proyectopc.modelo.Score;
import com.example.proyectopc.modelo.Status;
import com.example.proyectopc.repositorio.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusServices {

    @Autowired
    private StatusRepository statusRepository;

    public List<Status> getAll(){
        return statusRepository.getAll();
    }
    public Optional<Status> getStatus(int id){
        return statusRepository.getStatus(id);
    }
    public Status save(Status p){
        if(p.getIdStatus()==null){
            return statusRepository.save(p);
        } else {
            Optional<Status> e = statusRepository.getStatus(p.getIdStatus());
            if(e.isPresent()){
                return p;
            }else{
                return statusRepository.save(p);
            }
        }
    }

    public Status update(Status p){
        if(p.getIdStatus()!=null){
            Optional<Status> q = statusRepository.getStatus(p.getIdStatus());
            if(q.isPresent()){
                if(p.getStatus()!=null){
                    q.get().setStatus(p.getStatus());
                }
                if(p.getReservation()!=null){
                    q.get().setReservation(p.getReservation());
                }
                statusRepository.save(q.get());
                return q.get();
            }else {
                return p;
            }
        }else{
            return p;
        }
    }
    public boolean delete(int id){

        boolean flag=false;
        Optional<Status>p= statusRepository.getStatus(id);
        if(p.isPresent()){
            statusRepository.delete(p.get());
            flag=true;
        }

        return flag;

    }


}
