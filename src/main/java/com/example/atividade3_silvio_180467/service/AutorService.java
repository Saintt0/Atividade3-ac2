package com.example.atividade3_silvio_180467.service;

import java.util.List;

import com.example.atividade3_silvio_180467.entity.Autor;
import com.example.atividade3_silvio_180467.repository.AutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    @Autowired
    private AutorRepository arepository;

    public List<Autor> getAutores(){
        return arepository.findAll();
    }
    
}