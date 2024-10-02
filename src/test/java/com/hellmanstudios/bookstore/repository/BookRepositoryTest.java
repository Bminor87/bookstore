package com.hellmanstudios.bookstore.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.hellmanstudios.bookstore.domain.Book;
import com.hellmanstudios.bookstore.domain.Category;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository crepository;

    @Test
    public void findByTitleShouldReturnBook() {
        List<Book> books = repository.findByTitle("Pride and Prejudice");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Jane Austen");
    }

    @Test
    public void createNewBook() {
        Category category = new Category("Autobiography");
        crepository.save(category);
        Book book = new Book("Anne Frank", "The Diary", "1234567890123", 1947, 10.0, category);
        repository.save(book);
        assertThat(book.getId()).isNotNull();
    }
}