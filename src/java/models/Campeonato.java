/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Blob;
import java.sql.Date;

/**
 *
 * @author filip
 */
public class Campeonato {
    private int id;
    private String nome;
    private Date datainicio;
    private Date datafim;
    private Blob regulamento;

    public Campeonato() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatafim() {
        return datafim;
    }

    public void setDatafim(Date datafim) {
        this.datafim = datafim;
    }

    public Blob getRegulamento() {
        return regulamento;
    }

    public void setRegulamento(Blob regulamento) {
        this.regulamento = regulamento;
    }
    
    
}
