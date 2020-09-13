package pl.coderslab.book;

import java.util.List;

public interface BookService {

    public Book findBook(long id);


    public void addBook(Book book);

    public List<Book> findAll();

    public void deleteBook(long id);

    public void edit(long id, Book editedBook);
}
