package com.example.atividade3_silvio_180467.controller;

import com.example.atividade3_silvio_180467.entity.Autor;
import com.example.atividade3_silvio_180467.service.AutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AutorController {
    
    @Autowired
    private AutorService aservice;

    @GetMapping("/autores")
    public ModelAndView getAutores(){

        ModelAndView mv = new ModelAndView("autores");
        mv.addObject("autores", aservice.getAutores());
        return mv;
        
    }

    @PostMapping("/salvar")
    public String salvarAutor(@ModelAttribute Autor autor){
        aservice.salvar(autor);
        return "autores";
    }
    
}