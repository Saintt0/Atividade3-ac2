package com.example.atividade3_silvio_180467.controller;

import com.example.atividade3_silvio_180467.entity.Editora;
import com.example.atividade3_silvio_180467.service.EditoraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditoraController {

    @Autowired
    private EditoraService eservice;

    @GetMapping("/editoras")
    public ModelAndView getEditoras(){

        ModelAndView mv = new ModelAndView("editorasTemplate");
        mv.addObject("editoras", eservice.getEditoras());

        return mv;
    }

    @GetMapping("/detalhesEditora/{id}")
    public ModelAndView getEditoraDetalhes(@PathVariable(name = "id") Integer id){

        Editora editora = eservice.getEditoraById(id);
        ModelAndView mv = new ModelAndView("detalhesEditora");
        mv.addObject("editora", editora);

        return mv;
    }

    @PostMapping("/salvarEditora")
    public String salvar(@ModelAttribute Editora editora){
        eservice.salvar(editora);
        return "redirect:/editoras";
    }
    


}