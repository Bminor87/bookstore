package com.hellmanstudios.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hellmanstudios.bookstore.domain.Book;
import com.hellmanstudios.bookstore.domain.Category;
import com.hellmanstudios.bookstore.repository.BookRepository;
import com.hellmanstudios.bookstore.repository.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			categoryRepository.save(new Category("Fantasy"));
			categoryRepository.save(new Category("Science Fiction"));
			categoryRepository.save(new Category("Horror"));
			categoryRepository.save(new Category("Romance"));
			categoryRepository.save(new Category("Mystery"));
			categoryRepository.save(new Category("Thriller"));
			categoryRepository.save(new Category("Historical Fiction"));
			categoryRepository.save(new Category("Western"));
			categoryRepository.save(new Category("Dystopian"));
			categoryRepository.save(new Category("Memoir"));
			categoryRepository.save(new Category("Self-Help"));
			categoryRepository.save(new Category("Cookbook"));
			categoryRepository.save(new Category("Biography"));
			categoryRepository.save(new Category("Autobiography"));
			categoryRepository.save(new Category("Adventure"));

			Category fantasy = categoryRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("Category not found"));
			Category scienceFiction = categoryRepository.findById(2L).orElseThrow(() -> new IllegalArgumentException("Category not found"));
			Category horror = categoryRepository.findById(3L).orElseThrow(() -> new IllegalArgumentException("Category not found"));
			Category romance = categoryRepository.findById(4L).orElseThrow(() -> new IllegalArgumentException("Category not found"));
			Category mystery = categoryRepository.findById(5L).orElseThrow(() -> new IllegalArgumentException("Category not found"));
			Category thriller = categoryRepository.findById(6L).orElseThrow(() -> new IllegalArgumentException("Category not found"));
			Category historicalFiction = categoryRepository.findById(7L).orElseThrow(() -> new IllegalArgumentException("Category not found"));
			Category western = categoryRepository.findById(8L).orElseThrow(() -> new IllegalArgumentException("Category not found"));
			Category dystopian = categoryRepository.findById(9L).orElseThrow(() -> new IllegalArgumentException("Category not found"));
			Category memoir = categoryRepository.findById(10L).orElseThrow(() -> new IllegalArgumentException("Category not found"));
			Category selfHelp = categoryRepository.findById(11L).orElseThrow(() -> new IllegalArgumentException("Category not found"));
			Category cookbook = categoryRepository.findById(12L).orElseThrow(() -> new IllegalArgumentException("Category not found"));
			Category biography = categoryRepository.findById(13L).orElseThrow(() -> new IllegalArgumentException("Category not found"));
			Category autobiography = categoryRepository.findById(14L).orElseThrow(() -> new IllegalArgumentException("Category not found"));
			Category adventure = categoryRepository.findById(15L).orElseThrow(() -> new IllegalArgumentException("Category not found"));

			bookRepository.save(new Book("George R.R. Martin", "Tuli & Veri", "9789511493440", 2024, 31.95, fantasy));
			bookRepository.save(new Book("J.R.R. Tolkien", "Taru Sormusten Herrasta", "9789510499399", 2023, 54.95, fantasy));
			bookRepository.save(new Book("Harper Lee", "To Kill a Mockingbird", "9780061120084", 1960, 18.99, fantasy));
			bookRepository.save(new Book("F. Scott Fitzgerald", "The Great Gatsby", "9780743273565", 1925, 10.99, fantasy));
			bookRepository.save(new Book("George Orwell", "1984", "9780451524935", 1949, 15.99, dystopian));
			bookRepository.save(new Book("Jane Austen", "Pride and Prejudice", "9781503290563", 1813, 8.99, romance));
			bookRepository.save(new Book("Herman Melville", "Moby-Dick", "9781503280786", 1851, 12.99, adventure));
			bookRepository.save(new Book("Leo Tolstoy", "War and Peace", "9780199232765", 1869, 19.99, historicalFiction));
			bookRepository.save(new Book("Markus Zusak", "The Book Thief", "9780375842207", 2005, 12.95, historicalFiction));
			bookRepository.save(new Book("J.K. Rowling", "Harry Potter and the Philosopher's Stone", "9780747532699", 1997, 20.99, fantasy));
			bookRepository.save(new Book("Stephen King", "The Shining", "9780385121675", 1977, 14.99, horror));
			bookRepository.save(new Book("Agatha Christie", "Murder on the Orient Express", "9780062693662", 1934, 9.99, mystery));
			bookRepository.save(new Book("Ernest Hemingway", "The Old Man and the Sea", "9780684830490", 1952, 13.99, adventure));
			bookRepository.save(new Book("Gabriel García Márquez", "One Hundred Years of Solitude", "9780060883287", 1967, 16.99, fantasy));
			bookRepository.save(new Book("Isaac Asimov", "Foundation", "9780553293357", 1951, 17.99, scienceFiction));
			
		};
	}

}
