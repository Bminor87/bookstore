package com.hellmanstudios.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import com.hellmanstudios.bookstore.domain.Book;
import java.util.List;


public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
