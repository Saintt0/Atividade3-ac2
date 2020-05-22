package com.example.atividade3_silvio_180467.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Editora implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String sede;
    private int anof;//ano de fundação

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

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public int getAnof() {
        return anof;
    }

    public void setAnof(int anof) {
        this.anof = anof;
    }

    @Override
    public String toString() {
        return "Editora [anof=" + anof + ", id=" + id + ", nome=" + nome + ", sede=" + sede + "]";
    }
    
}