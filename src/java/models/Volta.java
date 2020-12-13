/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author filip
 */
public class Volta {
    /*
    id int not null auto_increment,
    tipo varchar(45),
    tempo decimal(10,4),
    horaChegada varchar(10),
    horaSaida varchar(10),
    idParticipante int not null,
    idEtapa int not null,
    */
    
    private int id;
    private String tipo;
    private float tempo;
    private String horachegada;
    private String horaSaida;
    private int idParticipante;
    private int idEtapa;

    public Volta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getTempo() {
        return tempo;
    }

    public void setTempo(float tempo) {
        this.tempo = tempo;
    }

    public String getHorachegada() {
        return horachegada;
    }

    public void setHorachegada(String horachegada) {
        this.horachegada = horachegada;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public int getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(int idEtapa) {
        this.idEtapa = idEtapa;
    }
    
    
}
