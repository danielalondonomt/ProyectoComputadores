package com.example.proyectopc.Controlador;

import com.example.proyectopc.Servicios.ReservationServices;
import com.example.proyectopc.modelo.DTOs.CountClient;
import com.example.proyectopc.modelo.DTOs.CountStatus;
import com.example.proyectopc.modelo.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationServices reservationServices;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationServices.getAll();

    }
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        return reservationServices.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation p){
        return reservationServices.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation p){
        return reservationServices.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return reservationServices.delete(id);
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReportReservationBetweenDates(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return reservationServices.getReservationBetweenDates(dateOne, dateTwo);
    }

    @GetMapping("/report-status")
    public CountStatus getReportStatus(){
        return reservationServices.getReservationsStatus();
    }

    @GetMapping("/report-clients")
    public List<CountClient> getBestClient(){
        return reservationServices.getBestClient();
    }


}
