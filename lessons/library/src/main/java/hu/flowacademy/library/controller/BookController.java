package hu.flowacademy.library.controller;

import hu.flowacademy.library.model.Book;
import hu.flowacademy.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/findByTitle/{title}")
    public List<Book> findBookByTitle(@PathVariable String title) {
        return bookService.findByTitle(title);
    }

    @GetMapping("/findById/{id}")
    public Book findBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @GetMapping("/findAllBooks")
    public List<Book> findAllBooks() {
        return bookService.findAll();
    }

    @DeleteMapping("/deleteBook/{id}")
    public void deleteBookById(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @PutMapping("/updateBook")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

}
