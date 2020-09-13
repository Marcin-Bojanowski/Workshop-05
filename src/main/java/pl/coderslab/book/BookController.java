package pl.coderslab.book;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @GetMapping("/hello")
    public String hello() {
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("")
    public List<Book> allBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findBook(@PathVariable long id) {
        return bookService.findBook(id);
    }

    @PostMapping("")
    public String addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return "book";
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
    }

    @PutMapping("/{id}")
    public void editBook(@RequestBody Book book, @PathVariable long id) {
        bookService.edit(id, book);

    }
}
