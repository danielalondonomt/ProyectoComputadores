package com.example.proyectopc.repositorio;

import com.example.proyectopc.modelo.Client;
import com.example.proyectopc.modelo.DTOs.CountClient;
import com.example.proyectopc.modelo.Reservation;
import com.example.proyectopc.repositorio.CRUD.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    public Reservation save(Reservation p){
        return reservationCrudRepository.save(p);
    }
    public void delete(Reservation p){
        reservationCrudRepository.delete(p);
    }

        //Reto 5

        //Cantidad de reservas en fechas
    public List<Reservation> getReservationBetweenDates(Date a, Date b) {
        return reservationCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(a,b);
    }

        //Cantidad de Reservas Completadas y Canceladas
    public List<Reservation> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

        //Top de los mejores
       public List<CountClient> getBestClient(){
       List<CountClient> request=new ArrayList<>();

        List<Object[]> report=reservationCrudRepository.countTotalReservationsByClient();
       for(int i=0; i<report.size(); i++){
           request.add(new CountClient((Long) report.get(i)[1], (Client) report.get(i)[0]));
       }return request;
    }

}
