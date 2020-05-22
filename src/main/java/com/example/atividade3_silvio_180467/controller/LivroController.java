package com.example.atividade3_silvio_180467.controller;

import com.example.atividade3_silvio_180467.entity.Livro;
import com.example.atividade3_silvio_180467.service.AutorService;
import com.example.atividade3_silvio_180467.service.EditoraService;
import com.example.atividade3_silvio_180467.service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LivroController {

    @Autowired
    private LivroService lservice;
    
    @Autowired
    private EditoraService eservice;
    
    @Autowired
    private AutorService aservice;


    @GetMapping("/livros")
    public ModelAndView getLivros(){

        ModelAndView mv = new ModelAndView("livrosTemplate");
        
        mv.addObject("livro", new Livro());
        mv.addObject("livros", lservice.getLivros());
        mv.addObject("editoras", eservice.getEditoras());

        return mv;
    }

    @PostMapping("/salvarLivros")
    public String salvar(@ModelAttribute Livro livro){
        lservice.salvar(livro);
        return "redirect:/livros";
    }

    @GetMapping("/editarLivro")
    public ModelAndView editarLivro(@RequestParam Integer id){

        ModelAndView mv = new ModelAndView("livroEdit");

        Livro livro = lservice.getLivroById(id);
        mv.addObject("livro", livro);
        mv.addObject("autores", aservice.getAutores());

        return mv;
    }

    @GetMapping("/removerLivro")
    public String removerLivro(@RequestParam Integer id){

        Livro livro = lservice.getLivroById(id);
        lservice.remover(livro);

        return "redirect:/livros";
    }
    
}