package com.example.atividade3_silvio_180467.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;

@Entity
public class Autor implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String pseudonimo;
    private String nome;
    private String po;//País de Origem

    @ManyToMany
    @JoinTable(
        name = "AUTOR_LIVRO", 
        uniqueConstraints =  @UniqueConstraint(columnNames = { "ID_AUTOR", "ID_LIVRO" }),
        joinColumns = @JoinColumn(name = "ID_AUTOR"),
        inverseJoinColumns = @JoinColumn(name = "ID_LIVRO")
    )
    private List<Livro> livros;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudonimo() {
        return pseudonimo;
    }

    public void setPseudonimo(String pseudonimo) {
        this.pseudonimo = pseudonimo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po;
    }


    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "Autor [id=" + id + ", nome=" + nome + ", po=" + po + ", pseudonimo=" + pseudonimo + "]";
    }

}