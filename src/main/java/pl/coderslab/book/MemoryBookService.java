package pl.coderslab.book;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Service
public class MemoryBookService implements BookService{
    private List<Book> list;
    private long id = 1;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(id, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        id++;
        list.add(new Book(id, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        id++;
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
        id++;
    }

    public Book findBook(long id) {
        return list.stream().filter(b -> b.getId() == id)
                .findFirst().get();
    }

    public void addBook(Book book) {
        book.setId(id);
        id++;
        list.add(book);
    }

    public List<Book> findAll() {
        return list;
    }

    public void deleteBook(long id) {
        list.removeIf(book -> book.getId() == id);
    }

    public void edit(long id, Book editedBook) {
        list.forEach(book -> {
            if (book.getId() == id) {
                list.set(list.indexOf(book), editedBook);
            }
        });
    }

}