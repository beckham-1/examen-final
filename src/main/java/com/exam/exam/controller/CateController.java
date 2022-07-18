/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exam.exam.controller;

import com.exam.exam.entity.Categoria;
import com.exam.exam.serviceImpl.CategoriaService;
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
@RequestMapping("/cate")
public class CateController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/all")
    public String listarCate(Model model) {
        model.addAttribute("categorias", categoriaService.readAll());
        return "/cate/listarCate";
    }

    @PostMapping("/{id}")
    public String readCate(Model model, @PathVariable("id") Integer idcat) {
        model.addAttribute("cate", categoriaService.read(idcat));

        return "redirect:/cate";
    }

    @PostMapping("/add")
    public String saveCate(@Valid @ModelAttribute Categoria cat, BindingResult result, Model model, RedirectAttributes attributes) {
        categoriaService.create(cat);
        //model.addAttribute("categorias", categoriaService.readAll());
        return "redirect:/cate/all";
    }

    @GetMapping("/form")
    public String createCate(Model model) {
        model.addAttribute("titulo", "Registrar Categoría");
        model.addAttribute("categoria", new Categoria());
        return "cate/formCate";
    }

    @GetMapping("/del/{id}")
    public String deleteCate(Model model, @PathVariable("id") Integer idcat) {
        categoriaService.delete(idcat);
        return "redirect:/cate/all";
    }//PUT,PATCH,GET;DELETE,POST

    @GetMapping("/edit/{id}")
    public String editCate(Model model, @PathVariable("id") Integer idcat) {
        Categoria categoria = categoriaService.read(idcat);
        model.addAttribute("titulo", "Modificar Categoría");
        model.addAttribute("categoria", categoria);
        return "cate/formCate";
    }
}
