package com.example.atividade3_silvio_180467.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String genero;//apenas um genero por livro
    private int nump;//numero de páginas

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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNump() {
        return nump;
    }

    public void setNump(int nump) {
        this.nump = nump;
    }

    @Override
    public String toString() {
        return "Livro [genero=" + genero + ", id=" + id + ", nome=" + nome + ", nump=" + nump + "]";
    }
    
}