package com.exam.exam.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author admin
 */
@Controller

public class HomeController {

   

    @GetMapping("/")
    public String home() {
       
        return "index";
    }
    
   
  
}
