package com.exam.exam.controller;


import com.exam.exam.serviceImpl.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author admin
 */
@Controller

public class HomeController {

   
    @Autowired
    private PedidosService pedidosService;


    @GetMapping("/")
    public String listarPedidos(Model model) {
        model.addAttribute("pedidos", pedidosService.readAll());
        return "/pedidos/listarPedidos";
    }
    
   
  
}
