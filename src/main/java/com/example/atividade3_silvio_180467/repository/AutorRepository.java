package com.example.atividade3_silvio_180467.repository;

import com.example.atividade3_silvio_180467.entity.Autor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
    
}