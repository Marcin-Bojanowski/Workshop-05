package pl.coderslab.book;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
public class Book {
    private long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String type;
}
