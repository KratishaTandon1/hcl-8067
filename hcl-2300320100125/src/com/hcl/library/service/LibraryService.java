package com.hcl.library.service;

import com.hcl.library.exception.*;
import com.hcl.library.model.*;
import com.hcl.library.repository.*;
import com.hcl.library.util.SearchCache;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class LibraryService {
    private Repository<LibraryItem, Integer> itemRepo = new InMemoryRepository<>(LibraryItem::getId);
    private Repository<Member, Integer> memberRepo = new InMemoryRepository<>(Member::getId);

    // item id -> queue of waiting members
    private Map<Integer, Queue<Member>> waitlistMap = new HashMap<>();
    private SearchCache<String, String> searchCache = new SearchCache<>(5);

    public void addItem(LibraryItem item) {
        itemRepo.save(item);
    }

    public void registerMember(Member member) {
        memberRepo.save(member);
    }

    public void borrowItem(int memberId, int itemId) {
        Member m = memberRepo.findById(memberId)
                .orElseThrow(() -> new ItemNotFoundException("Member " + memberId + " not found"));

        LibraryItem item = itemRepo.findById(itemId)
                .orElseThrow(() -> new ItemNotFoundException("Item " + itemId + " not found"));

        if (!item.isAvailable()) {
            throw new ItemNotAvailableException("Item " + itemId + " is already borrowed!");
        }

        if (m.getBorrowedItemIds().size() >= 3) {
            throw new BorrowLimitExceededException("Limit reached! Cannot borrow more than 3 items.");
        }

        item.borrow();
        m.addBorrowedItem(itemId);
    }

    public String returnItem(int itemId, int daysLate) {
        LibraryItem item = itemRepo.findById(itemId)
                .orElseThrow(() -> new ItemNotFoundException("Item not found"));

        if (item.isAvailable()) {
            throw new LibraryException("This item wasn't even checked out.");
        }

        item.giveBack();

        // Find which member had it and remove from their list
        for (Member m : memberRepo.findAll()) {
            if (m.getBorrowedItemIds().contains(itemId)) {
                m.removeBorrowedItem(itemId);
                break;
            }
        }

        double fee = item.lateFee(daysLate);
        String msg = "Late fee to pay: " + fee;

        // Check if anyone is waiting in queue
        Queue<Member> q = waitlistMap.get(itemId);
        if (q != null && !q.isEmpty()) {
            Member nextPerson = q.poll();
            msg += "\nNotification: Member " + nextPerson.getId() + " (" + nextPerson.getName() + ") is next in line for item " + itemId + "!";
        }

        return msg;
    }

    public void addToWaitlist(int memberId, int itemId) {
        Member m = memberRepo.findById(memberId).orElseThrow(() -> new ItemNotFoundException("Member not found"));
        itemRepo.findById(itemId).orElseThrow(() -> new ItemNotFoundException("Item not found"));

        waitlistMap.putIfAbsent(itemId, new ArrayDeque<>());
        waitlistMap.get(itemId).add(m);
    }

    public List<LibraryItem> listSortedByTitle() {
        List<LibraryItem> list = new ArrayList<>(itemRepo.findAll());
        Collections.sort(list); // uses compareTo in LibraryItem
        return list;
    }

    public void exportReport(String filePath) {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(filePath))) {
            for (LibraryItem item : itemRepo.findAll()) {
                writer.write(item.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new LibraryException("IO error during export", e);
        }
    }

    public void printStatistics() {
        int books = 0, magazines = 0, dvds = 0;
        for (LibraryItem item : itemRepo.findAll()) {
            if (item instanceof Book) books++;
            else if (item instanceof Magazine) magazines++;
            else if (item instanceof DVD) dvds++;
        }
        System.out.println("--- Library Stats ---");
        System.out.println("Books: " + books);
        System.out.println("Magazines: " + magazines);
        System.out.println("DVDs: " + dvds);
    }
}