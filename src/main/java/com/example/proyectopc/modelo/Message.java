package com.example.proyectopc.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;


    @ManyToOne
    @JoinColumn(name="idComputer")
    @JsonIgnoreProperties({"computers","messages","reservations","client"})
    private Computer computers;
    @ManyToOne
    @JoinColumn(name="idClient")
    @JsonIgnoreProperties({"computers","messages","reservations","client"})
    private Client client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Computer getComputers() {
        return computers;
    }

    public void setComputers(Computer computer) {
        this.computers = computer;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
