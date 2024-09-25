package com.hellmanstudios.bookstore.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.hellmanstudios.bookstore.BookstoreApplication;
import com.hellmanstudios.bookstore.domain.Book;
import com.hellmanstudios.bookstore.repository.BookRepository;
import com.hellmanstudios.bookstore.repository.CategoryRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class BookController {
@Autowired
private BookRepository bookRepository;
@Autowired
private CategoryRepository categoryRepository;

    private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

    @GetMapping("*")
    public String fallback() {
        return "redirect:/index";
    }
     
    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("login")
    public String login() {	
        return "login";
    }	

    @GetMapping("/addbook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("editing", false);
        return "bookform";
    }

    @GetMapping("/editbook/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + bookId));
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("editing", true);
        return "bookform";
    }

    @PostMapping("/savebook")
    public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {
        log.info("validating input for book id: " + book.getId());
        if (bindingResult.hasErrors()) {
            model.addAttribute("book", book);
            model.addAttribute("categories", categoryRepository.findAll());
            model.addAttribute("editing", book.getId() != null);
            return "bookform";
        }
        bookRepository.save(book);
        return "redirect:/booklist";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable("id") Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + bookId));
        bookRepository.delete(book);
        return "redirect:/booklist";
    }

    @RequestMapping(value= {"/", "booklist"})
    public String bookList(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }
    
}
