package com.example.atividade3_silvio_180467.controller;

import com.example.atividade3_silvio_180467.service.EditoraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditoraController {

    @Autowired
    private EditoraService eservice;

    @GetMapping("/editoras")
    public ModelAndView getEditoras(){

        ModelAndView mv = new ModelAndView("editoras");
        mv.addObject("editoras", eservice.getEditoras());

        return mv;
    }
    
}