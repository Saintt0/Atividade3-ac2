package com.example.atividade3_silvio_180467.service;

import java.util.List;

import com.example.atividade3_silvio_180467.entity.Editora;
import com.example.atividade3_silvio_180467.repository.EditoraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository erepository;

    public List<Editora> getEditoras(){
        return erepository.findAll();
    }

    public void salvar(Editora editora){
        erepository.save(editora);
    }
    
}