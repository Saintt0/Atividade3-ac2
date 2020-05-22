package com.example.atividade3_silvio_180467.controller;

import com.example.atividade3_silvio_180467.service.AutorService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AutorController {
    
    private AutorService aservice;

    @GetMapping("/autores")
    public ModelAndView getAutores(){

        ModelAndView mv = new ModelAndView("autores");
        mv.addObject("autores", aservice.getAutores());
        return mv;
        
    }
    
}