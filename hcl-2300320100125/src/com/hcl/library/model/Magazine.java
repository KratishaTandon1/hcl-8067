package com.hcl.library.model;

public class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(String title, int year, int issueNumber) {
        super(title, year);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() { return issueNumber; }

    @Override
    public double lateFee(int daysLate) {
        return daysLate * 1.0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Magazine[").append(getId()).append(", ").append(getTitle())
                .append(", ").append(getYear()).append(", Issue #").append(issueNumber).append("]");
        return sb.toString();
    }
}