package com.hcl.library;

import com.hcl.library.exception.LibraryException;
import com.hcl.library.model.Book;
import com.hcl.library.model.DVD;
import com.hcl.library.model.Magazine;
import com.hcl.library.model.Member;
import com.hcl.library.service.LibraryService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryService service = new LibraryService();
        Scanner sc = new Scanner(System.in);

        // Pre-load a few test items and members
        try {
            service.addItem(new Book("Clean Code", 2008, "Robert Martin", "9780132350884"));
            service.addItem(new Magazine("Tech Today", 2024, 45));
            service.registerMember(new Member(1, "Alice", "alice@example.com"));
            service.registerMember(new Member(2, "Ravi", "ravi@example.com"));
        } catch (Exception e) {
            System.out.println("Init error: " + e.getMessage());
        }

        int choice = -1;
        do {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add item");
            System.out.println("2. Register member");
            System.out.println("3. Borrow");
            System.out.println("4. Return");
            System.out.println("5. Waitlist");
            System.out.println("6. List items");
            System.out.println("7. Search / Stats");
            System.out.println("8. Export report");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine(); // clear newline buffer

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter item type (book / magazine / dvd): ");
                        String type = sc.nextLine().trim().toLowerCase();
                        System.out.print("Title: ");
                        String title = sc.nextLine();
                        System.out.print("Year: ");
                        int year = sc.nextInt();
                        sc.nextLine();

                        if (type.equals("book")) {
                            System.out.print("Author: ");
                            String author = sc.nextLine();
                            System.out.print("ISBN: ");
                            String isbn = sc.nextLine();
                            service.addItem(new Book(title, year, author, isbn));
                        } else if (type.equals("magazine")) {
                            System.out.print("Issue Number: ");
                            int issue = sc.nextInt();
                            sc.nextLine();
                            service.addItem(new Magazine(title, year, issue));
                        } else if (type.equals("dvd")) {
                            System.out.print("Duration (mins): ");
                            int duration = sc.nextInt();
                            sc.nextLine();
                            service.addItem(new DVD(title, year, duration));
                        } else {
                            System.out.println("Unknown item type!");
                            break;
                        }
                        System.out.println("Item added successfully.");
                        break;

                    case 2:
                        System.out.print("Member Name: ");
                        String name = sc.nextLine();
                        System.out.print("Member Email: ");
                        String email = sc.nextLine();
                        service.registerMember(new Member(name, email));
                        System.out.println("Member registered successfully.");
                        break;

                    case 3:
                        System.out.print("Member id: ");
                        int memberId = sc.nextInt();
                        System.out.print("Item id: ");
                        int itemId = sc.nextInt();
                        sc.nextLine();

                        try {
                            service.borrowItem(memberId, itemId);
                            System.out.println("Issued successfully.");
                        } catch (LibraryException e) {
                            System.out.println("ERROR: " + e.getMessage());
                            System.out.print("Add to waitlist? (y/n): ");
                            String ans = sc.nextLine();
                            if (ans.equalsIgnoreCase("y")) {
                                service.addToWaitlist(memberId, itemId);
                                System.out.println("Added to waitlist.");
                            }
                        }
                        break;

                    case 4:
                        System.out.print("Item id: ");
                        int retItemId = sc.nextInt();
                        System.out.print("Late by (days): ");
                        int daysLate = sc.nextInt();
                        sc.nextLine();

                        String res = service.returnItem(retItemId, daysLate);
                        System.out.println(res);
                        break;

                    case 5:
                        System.out.print("Member id: ");
                        int wMemberId = sc.nextInt();
                        System.out.print("Item id: ");
                        int wItemId = sc.nextInt();
                        sc.nextLine();
                        service.addToWaitlist(wMemberId, wItemId);
                        System.out.println("Added to waitlist queue.");
                        break;

                    case 6:
                        System.out.println("\n--- All Items Sorted by Title ---");
                        service.listSortedByTitle().forEach(System.out::println);
                        break;

                    case 7:
                        service.printStatistics();
                        break;

                    case 8:
                        System.out.print("Enter report file path (e.g. report.txt): ");
                        String path = sc.nextLine();
                        service.exportReport(path);
                        System.out.println("Report exported to " + path);
                        break;

                    case 0:
                        System.out.println("Exiting application. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Try between 0 and 8.");
                }
            } catch (Exception ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        } while (choice != 0);

        sc.close();
    }
}