package com.hellmanstudios.bookstore.domain;

public class Book {

    private String title, author, isbn;
    private int publicationYear;
    private double price;

    public Book() {
        this.title = "";
        this.author = "";
        this.isbn = "";
        this.publicationYear = 1970;
        this.price = 0;
    }

    public Book(String title, String author, String isbn, int publicationYear, double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return author + ": " + title;
    }

}
