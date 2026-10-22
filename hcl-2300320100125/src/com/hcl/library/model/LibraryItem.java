package com.hcl.library.model;

import java.util.Objects;

public abstract class LibraryItem implements Borrowable, Comparable<LibraryItem> {
    private static int idCounter = 1001;

    private int id;
    private String title;
    private int year;
    private boolean available;

    public LibraryItem(String title, int year) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title can't be empty yaar");
        }
        int currentYear = java.time.Year.now().getValue();
        if (year < 1900 || year > currentYear) {
            throw new IllegalArgumentException("Invalid year provided.");
        }
        this.id = idCounter++;
        this.title = title;
        this.year = year;
        this.available = true; // default available when created
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public boolean isAvailable() {
        return available;
    }

    public void borrow() {
        this.available = false;
    }

    public void giveBack() {
        this.available = true;
    }

    public abstract double lateFee(int daysLate);

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Year: " + year + ", Available: " + available;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LibraryItem that = (LibraryItem) obj;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Natural sorting by title alphabetically
    @Override
    public int compareTo(LibraryItem o) {
        return this.title.compareToIgnoreCase(o.title);
    }
}