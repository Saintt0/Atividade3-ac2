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
import javax.persistence.ManyToOne;

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
    
    @ManyToMany
    @JoinTable(name = "AUTOR_LIVRO", joinColumns = @JoinColumn(name = "LIVRO_ID"), inverseJoinColumns = @JoinColumn(name = "AUTOR_ID"))
    private List<Autor> autores;

    @ManyToOne
    @JoinColumn(name = "ID_EDITORA")
    private Editora editora;

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

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    @Override
    public String toString() {
        return "Livro [editora=" + editora.getNome() + ", genero=" + genero + ", id=" + id + ", nome=" + nome + ", nump=" + nump
                + "]";
    }

    
    
}