package hu.flowacademy.library;

import hu.flowacademy.library.model.Book;
import hu.flowacademy.library.model.Page;
import hu.flowacademy.library.repository.BookRepository;
import hu.flowacademy.library.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Autowired
	BookRepository bookRepository;

	@Autowired
	PageRepository pageRepository;

	@Bean
	public CommandLineRunner runner() {
		return args -> {
			Book book = new Book("C", 1000L, LocalDate.of(2021, 1, 1));
			bookRepository.save(book);

			Page page = new Page(1, book);
			Page page2 = new Page(2, book);
			Page page3 = new Page(3, book);

			pageRepository.save(page);
			pageRepository.save(page2);
			pageRepository.save(page3);
		};
	}
}
