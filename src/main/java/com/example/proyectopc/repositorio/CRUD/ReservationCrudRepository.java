package com.example.proyectopc.repositorio.CRUD;

import com.example.proyectopc.modelo.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}
