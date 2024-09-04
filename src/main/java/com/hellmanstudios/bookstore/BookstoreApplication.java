package com.hellmanstudios.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hellmanstudios.bookstore.domain.Book;
import com.hellmanstudios.bookstore.repository.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {

			repository.save(new Book("George R.R. Martin", "Tuli & Veri", "9789511493440", 2024, 31.95));
			repository.save(new Book("J.R.R. Tolkien", "Taru Sormusten Herrasta", "9789510499399", 2023, 54.95));
			repository.save(new Book("Harper Lee", "To Kill a Mockingbird", "9780061120084", 1960, 18.99));
			repository.save(new Book("F. Scott Fitzgerald", "The Great Gatsby", "9780743273565", 1925, 10.99));
			repository.save(new Book("George Orwell", "1984", "9780451524935", 1949, 15.99));
			repository.save(new Book("Jane Austen", "Pride and Prejudice", "9781503290563", 1813, 8.99));
			repository.save(new Book("Herman Melville", "Moby-Dick", "9781503280786", 1851, 12.99));
			repository.save(new Book("Leo Tolstoy", "War and Peace", "9780199232765", 1869, 19.99));
			repository.save(new Book("Markus Zusak", "The Book Thief", "9780375842207", 2005, 12.95));
			repository.save(new Book("J.K. Rowling", "Harry Potter and the Philosopher's Stone", "9780747532699", 1997, 20.99));
			repository.save(new Book("Stephen King", "The Shining", "9780385121675", 1977, 14.99));
			repository.save(new Book("Agatha Christie", "Murder on the Orient Express", "9780062693662", 1934, 9.99));
			repository.save(new Book("Ernest Hemingway", "The Old Man and the Sea", "9780684830490", 1952, 13.99));
			repository.save(new Book("Gabriel García Márquez", "One Hundred Years of Solitude", "9780060883287", 1967, 16.99));
			repository.save(new Book("Isaac Asimov", "Foundation", "9780553293357", 1951, 17.99));
		};
	}

}
