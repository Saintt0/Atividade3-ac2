package com.example.atividade3_silvio_180467.controller;

import com.example.atividade3_silvio_180467.service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LivroController {

    @Autowired
    private LivroService lservice;

    @GetMapping("/livros")
    public ModelAndView getLivros(){

        ModelAndView mv = new ModelAndView("livros");
        mv.addObject("livros", lservice.getLivros());

        return mv;
    }
    
}