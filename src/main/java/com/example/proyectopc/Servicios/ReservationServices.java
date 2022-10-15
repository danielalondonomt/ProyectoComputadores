package com.example.proyectopc.Servicios;

import com.example.proyectopc.modelo.DTOs.CountClient;
import com.example.proyectopc.modelo.DTOs.CountStatus;
import com.example.proyectopc.modelo.Reservation;
import com.example.proyectopc.repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServices {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    public Reservation save(Reservation p){
        if(p.getIdReservation()==null){
            return reservationRepository.save(p) ;
        } else {
            Optional<Reservation> e = reservationRepository.getReservation(p.getIdReservation());
            if(e.isPresent()){
                return p;
            }else{
                return reservationRepository.save(p);
            }
        }
    }

    public Reservation update(Reservation p) {
        if (p.getIdReservation() != null) {
            Optional<Reservation> q = reservationRepository.getReservation(p.getIdReservation());
            if (q.isPresent()) {
                if (p.getStartDate() != null) {
                    q.get().setStartDate(p.getStartDate());
                }
                if (p.getDevolutionDate() != null) {
                    q.get().setDevolutionDate(p.getDevolutionDate());
                }
                if(p.getClient()!=null){
                    q.get().setClient(p.getClient());
                }
                if(p.getComputer()!=null){
                    q.get().setComputer(p.getComputer());
                }
                if(p.getStatus()!=null){
                    q.get().setStatus(p.getStatus());
                }
                    reservationRepository.save(q.get());
                    return q.get();
                } else {
                    return p;
                }
            } else {
                return p;

        }
    }
        public boolean delete ( int id){

            boolean flag = false;
            Optional<Reservation> p = reservationRepository.getReservation(id);
            if (p.isPresent()) {
                reservationRepository.delete(p.get());
                flag = true;
            }

            return flag;

        }

        //Reto 5
        public List<Reservation> getReservationBetweenDates(String dateA, String dateB){
            SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
            Date a =new Date();
            Date b =new Date();
            try{
                a=parser.parse(dateA);
                b=parser.parse(dateB);
            }catch (ParseException error){
                error.printStackTrace();
            }
            if(a.before(b)){
                return reservationRepository.getReservationBetweenDates(a,b);
            }else{
                return new ArrayList<>();
            }
        }

        public CountStatus getReservationsStatus(){
            List<Reservation> reservesComplete = reservationRepository.getReservationByStatus("completed");
            List<Reservation> reservesCancelled = reservationRepository.getReservationByStatus("cancelled");

        return new CountStatus((long) reservesComplete.size(), (long) reservesCancelled.size());
        }
        public List<CountClient> getBestClient(){
            return reservationRepository.getBestClient();
        }



}
