package com.example.proyectopc.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="score")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idScore;
    private Integer score;

    @ManyToOne
    @JoinColumn(name="idReservation")
    @JsonIgnoreProperties({"reservations","score"})
    private Reservation reservations;

    public Integer getIdScore() {
        return idScore;
    }

    public void setIdScore(Integer idScore) {
        this.idScore = idScore;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Reservation getReservations() {
        return reservations;
    }

    public void setReservations(Reservation reservation) {
        this.reservations = reservation;
    }
}
