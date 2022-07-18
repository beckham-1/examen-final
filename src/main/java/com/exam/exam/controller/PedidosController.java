/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exam.exam.controller;

import com.exam.exam.entity.Pedidos;

import com.exam.exam.serviceImpl.PedidosService;
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
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @GetMapping("/all")
    public String listarPedidos(Model model) {
        model.addAttribute("pedidos", pedidosService.readAll());
        return "/pedidos/listarPedidos";
    }

    @PostMapping("/{id}")
    public String readCate(Model model, @PathVariable("id") Integer idcat) {
        model.addAttribute("cate", pedidosService.read(idcat));

        return "redirect:/pedidos";
    }

    @PostMapping("/add")
    public String saveCate(@Valid @ModelAttribute Pedidos ped, BindingResult result, Model model, RedirectAttributes attributes) {
        pedidosService.create(ped);
        //model.addAttribute("categorias", categoriaService.readAll());
        return "redirect:/pedidos/all";
    }

    @GetMapping("/form")
    public String createCate(Model model) {
        model.addAttribute("titulo", "Registrar Pedido");
        model.addAttribute("icon", "<i class=\"fa-solid fa-cart-plus\"></i>");
        model.addAttribute("pedidos", new Pedidos());
        return "pedidos/formPedidos";
    }

    @GetMapping("/del/{id}")
    public String deleteCate(Model model, @PathVariable("id") Integer idped) {
        pedidosService.delete(idped);
        return "redirect:/pedidos/all";
    }//PUT,PATCH,GET;DELETE,POST

    @GetMapping("/edit/{id}")
    public String editCate(Model model, @PathVariable("id") Integer idped) {
        Pedidos pedidos = pedidosService.read(idped);
        model.addAttribute("titulo", "Modificar Pedido");
        model.addAttribute("pedidos", pedidos);
        return "pedidos/formPedidos";
    }

}
