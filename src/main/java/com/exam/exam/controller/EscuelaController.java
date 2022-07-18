/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exam.exam.controller;


import com.exam.exam.entity.Escuela;
import com.exam.exam.serviceImpl.EscuelaService;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Noodlexz.CD
 */
@Controller
@RequestMapping("/escuela")
public class EscuelaController {

    @Autowired
    private EscuelaService escuelaService;

    @GetMapping("/all")
    public String listarCate(Model model) {
        model.addAttribute("escuela", escuelaService.readAll());
        return "/escuela/listarEscuela";
    }

    @PostMapping("/{id}")
    public String readCate(Model model, @PathVariable("id") Integer idcat) {
        model.addAttribute("cate", escuelaService.read(idcat));

        return "redirect:/escuela";
    }

    @PostMapping("/add")
    public String saveCate(@Valid @ModelAttribute Escuela cat, BindingResult result, Model model, RedirectAttributes attributes) {
        escuelaService.create(cat);
        //model.addAttribute("categorias", categoriaService.readAll());
        return "redirect:/escuela/all";
    }

    @GetMapping("/form")
    public String createCate(Model model) {
        model.addAttribute("titulo", "Registrar Escuela");
        model.addAttribute("escuela", new Escuela());
        return "escuela/formEscuela";
    }

    @GetMapping("/del/{id}")
    public String deleteCate(Model model, @PathVariable("id") Integer idcat) {
        escuelaService.delete(idcat);
        return "redirect:/escuela/all";
    }//PUT,PATCH,GET;DELETE,POST

    @GetMapping("/edit/{id}")
    public String editCate(Model model, @PathVariable("id") Integer idcat) {
        Escuela escuela = escuelaService.read(idcat);
        model.addAttribute("titulo", "Modificar Escuela");
        model.addAttribute("escuela", escuela);
        return "escuela/formEscuela";
    }

}
