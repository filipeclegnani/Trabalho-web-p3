/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author filip
 */
public class Piloto {
    /*
    id int not null auto_increment,
    nome varchar(250),
    email varchar(100),
    cpf varchar(11),
    dataNascimento date,
    cidade varchar(300),
    uf varchar(2),
    modelo_moto varchar(45),
    cilindrada varchar(45),
    marca varchar (150),
    primary key(id)
    */
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private Date dataNascimento;
    private String cidade;
    private String uf;
    private String modelo_moto;
    private String cilindrada;
    private String marca;

    public Piloto() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getModelo_moto() {
        return modelo_moto;
    }

    public void setModelo_moto(String modelo_moto) {
        this.modelo_moto = modelo_moto;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
           
}
