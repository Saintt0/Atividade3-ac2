package com.example.atividade3_silvio_180467.controller;

import java.util.List;

import com.example.atividade3_silvio_180467.entity.Autor;
import com.example.atividade3_silvio_180467.entity.Livro;
import com.example.atividade3_silvio_180467.service.AutorService;
import com.example.atividade3_silvio_180467.service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AutorController {
    
    @Autowired
    private AutorService aservice;
    @Autowired
    private LivroService lservice;

    @GetMapping("/autores")
    public ModelAndView getAutores(){

        ModelAndView mv = new ModelAndView("autoresTemplate");

        mv.addObject("autor", new Autor());
        mv.addObject("autores", aservice.getAutores());
        mv.addObject("livros", lservice.getLivros());
        
        return mv;
        
    }

    @PostMapping("/salvarAutor")
    public String salvarAutor(@ModelAttribute Autor autor){
        aservice.salvar(autor);
        return "redirect:/autores";
    }

    @PostMapping("/associarLivroAutor")
    public String associarLivro(@ModelAttribute Livro livro, @RequestParam Integer codigoAutor){

        Autor autor = aservice.getAutorById(codigoAutor);
        livro = lservice.getLivroById(livro.getId());

        autor.getLivros().add(livro);
        aservice.salvar(autor);

        return "redirect:/detalhesAutor/" + codigoAutor;
    }


    @GetMapping("/detalhesAutor/{codigo}")
    public ModelAndView getLivroDetalhes(@PathVariable(name = "codigo") Integer codigo){

        Autor autor = aservice.getAutorById(codigo);
        ModelAndView mv = new ModelAndView("detalhesAutor");
        mv.addObject("autor", autor);
        List<Livro> livrosNaoAssociados = lservice.getLivros();
        livrosNaoAssociados.removeAll(autor.getLivros());
        mv.addObject("livros", livrosNaoAssociados);

        return mv;
    }
    
}