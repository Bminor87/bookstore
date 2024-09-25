package com.hellmanstudios.bookstore.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import com.hellmanstudios.bookstore.domain.Book;
import com.hellmanstudios.bookstore.repository.BookRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/api")
public class BookRestController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    List<Book> getBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @GetMapping("/book/{id}")
    <Optional>Book findBook(@PathVariable("id") Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    @PostMapping("/book")
    Book newBook(@RequestBody Book newBook) {
        return bookRepository.save(newBook);
    }

    @PutMapping("/book/{id}")
    Book editBook(@RequestBody Book editedBook, @PathVariable Long id) {
        editedBook.setId(id);
        return bookRepository.save(editedBook);
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/book/{id}")
    List<Book> deleteBook(@PathVariable("id") Long bookId) {
        bookRepository.deleteById(bookId);
        return (List<Book>) bookRepository.findAll();
    }

    
}
