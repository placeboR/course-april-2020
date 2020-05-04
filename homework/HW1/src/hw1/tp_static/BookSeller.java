package hw1.tp_static;

import java.util.HashSet;
import java.util.Set;

public class BookSeller {
    public static class Book{
        private int ID;
        private String ISBN;
        private String NAME;
        private String AUTHOR;
        private String PUBLISH_DATE;
        Book(int id, String isbn, String name, String author, String publish_date){
            this.ID = id;
            this.ISBN = isbn;
            this.NAME = name;
            this.AUTHOR = author;
            this.PUBLISH_DATE = publish_date;
        }
        public void printBook(){
            System.out.println("ID: "+ ID + " Info: " + ISBN + " " + NAME + " " + AUTHOR + " " + PUBLISH_DATE);
        }
    }
    private static Set<Book> Books = new HashSet<>();
    public static void sellBooks(int num){
        for(int i=0; i<num; ++i){
            Books.add(new Book(i, String.valueOf(i),"Book" + String.valueOf(i), "Author" + String.valueOf(i), String.valueOf(i)));
        }
        for(Book b : Books){
            b.printBook();
        }
    }
    public static void main(String[] args){
        BookSeller.sellBooks(2);
    }
}
