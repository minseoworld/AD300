package org.example;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean NSCCollection;

    public Book(String title, String author, String ISBN, boolean NSCCollection) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.NSCCollection = NSCCollection;
    }

    public String getTitle() {
        return title;
    }

    public boolean isNSCCollection() {
        return NSCCollection;
    }
}
