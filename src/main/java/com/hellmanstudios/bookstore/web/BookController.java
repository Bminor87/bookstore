package com.hellmanstudios.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookController {

    @GetMapping("*")
    public String fallback() {
        return "redirect:/index";
    }
     
    @GetMapping("/index")
    public String index() {
        return "index";
    }
    
    

}
