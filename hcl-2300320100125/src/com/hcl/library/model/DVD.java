package com.hcl.library.model;

public class DVD extends LibraryItem {
    private int durationMinutes;

    public DVD(String title, int year, int durationMinutes) {
        super(title, year);
        this.durationMinutes = durationMinutes;
    }

    public int getDurationMinutes() { return durationMinutes; }

    @Override
    public double lateFee(int daysLate) {
        return daysLate * 5.0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DVD[").append(getId()).append(", ").append(getTitle())
                .append(", ").append(getYear()).append(", ").append(durationMinutes).append(" mins]");
        return sb.toString();
    }
}