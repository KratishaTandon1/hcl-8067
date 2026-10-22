package com.hcl.library.model;

import java.util.HashSet;
import java.util.Set;

public class Book extends LibraryItem {
    private static Set<String> isbnChecker = new HashSet<>();

    private String author;
    private String isbn;

    public Book(String title, int year, String author, String isbn) {
        super(title, year);
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be blank");
        }
        if (isbnChecker.contains(isbn)) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " already exists!");
        }
        isbnChecker.add(isbn);
        this.author = author;
        this.isbn = isbn;
    }

    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }

    @Override
    public double lateFee(int daysLate) {
        return daysLate * 2.0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Book[").append(getId()).append(", ").append(getTitle())
                .append(", ").append(getYear()).append(", ").append(author)
                .append(", ISBN: ").append(isbn).append("]");
        return sb.toString();
    }
}