package com.hellmanstudios.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BookController {

    @GetMapping("*")
    public String fallback() {
        return "redirect:/index";
    }
     
    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("test")
    public String simpleTestRemoveLater() {
        return "test";
    }
    
}
