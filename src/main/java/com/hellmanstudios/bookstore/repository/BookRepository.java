package com.hellmanstudios.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import com.hellmanstudios.bookstore.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
