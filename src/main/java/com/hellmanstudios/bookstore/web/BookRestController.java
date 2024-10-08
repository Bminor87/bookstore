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

import io.micrometer.core.ipc.http.HttpSender.Response;
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

    @GetMapping("/books/{id}")
    <Optional>Book findBook(@PathVariable("id") Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/books")
    ResponseEntity<Book> newBook(@Valid @RequestBody Book newBook) {
        Book savedBook = bookRepository.save(newBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/books/{id}")
    Book editBook(@Valid @RequestBody Book editedBook, @PathVariable Long id) {
        editedBook.setId(id);
        return bookRepository.save(editedBook);
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/books/{id}")
    List<Book> deleteBook(@PathVariable("id") Long bookId) {
        bookRepository.deleteById(bookId);
        return (List<Book>) bookRepository.findAll();
    }

    
}
