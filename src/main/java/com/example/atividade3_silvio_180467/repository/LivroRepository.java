package com.example.atividade3_silvio_180467.repository;

import com.example.atividade3_silvio_180467.entity.Livro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer>{
    
}