package com.study.spring.mvc.controller;

import com.study.spring.mvc.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @GetMapping("/product")
    public String product(Model model){
        Product p = new Product(1,"Keyboard");
        model.addAttribute("p1", p);
        return "main.html";
    }
}
