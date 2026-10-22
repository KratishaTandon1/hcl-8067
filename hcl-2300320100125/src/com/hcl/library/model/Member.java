package com.hcl.library.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member {
    private static int nextId = 1;

    private int id;
    private String name;
    private String email;
    private List<Integer> borrowedItemIds;

    public Member(String name, String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Bad email format!");
        }
        this.id = nextId++;
        this.name = name;
        this.email = email;
        this.borrowedItemIds = new ArrayList<>();
    }

    public Member(int id, String name, String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Bad email format!");
        }
        this.id = id;
        this.name = name;
        this.email = email;
        this.borrowedItemIds = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public List<Integer> getBorrowedItemIds() {
        return Collections.unmodifiableList(borrowedItemIds);
    }

    public void addBorrowedItem(int itemId) {
        borrowedItemIds.add(itemId);
    }

    public void removeBorrowedItem(int itemId) {
        borrowedItemIds.remove((Integer) itemId);
    }

    @Override
    public String toString() {
        return "Member[" + id + ", " + name + ", " + email + ", items count: " + borrowedItemIds.size() + "]";
    }
}