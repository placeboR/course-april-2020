package hw1.tp_static;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Book {
    private int ID;
    private String ISBN;
    private String NAME;
    private String AUTHOR;
    private String PUBLISH_DATE;
    private static Set<Book> Books = new HashSet<>();
    Book(int id, String isbn, String name, String author, String publish_date){
        this.ID = id;
        this.ISBN = isbn;
        this.NAME = name;
        this.AUTHOR = author;
        this.PUBLISH_DATE = publish_date;
    }
    static {
        Books.add(new Book(1, "978-3-16-148410-0", "Example", "ISBN Agency", "1970-01-01"));
        Books.add(new Book(2, "978-3-16-148410-1", "Example1", "ISBN Agency", "1970-01-01"));
    }
}
