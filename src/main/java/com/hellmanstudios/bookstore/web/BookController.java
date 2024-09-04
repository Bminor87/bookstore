package com.hellmanstudios.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hellmanstudios.bookstore.repository.BookRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class BookController {
@Autowired
private BookRepository repository;

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

    @RequestMapping(value= {"/", "booklist"})
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
    
    
}
