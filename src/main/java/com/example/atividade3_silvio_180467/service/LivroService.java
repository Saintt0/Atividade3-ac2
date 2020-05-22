package com.example.atividade3_silvio_180467.service;

import java.util.List;

import com.example.atividade3_silvio_180467.entity.Livro;
import com.example.atividade3_silvio_180467.repository.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository lrepository;

    public List<Livro> getLivros(){
        return lrepository.findAll();
    }
    
    public void salvar(Livro livro){
        lrepository.save(livro);
    }
}