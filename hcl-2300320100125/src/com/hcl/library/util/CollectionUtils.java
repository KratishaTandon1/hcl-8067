package com.hcl.library.util;

import com.hcl.library.model.LibraryItem;
import java.util.List;

public class CollectionUtils {

    public static <T extends Comparable<T>> T maxOf(List<T> list) {
        if (list == null || list.isEmpty()) return null;
        T maxItem = list.get(0);
        for (T item : list) {
            if (item.compareTo(maxItem) > 0) {
                maxItem = item;
            }
        }
        return maxItem;
    }

    public static double totalFees(List<? extends LibraryItem> items, int daysLate) {
        double sum = 0;
        for (LibraryItem item : items) {
            sum += item.lateFee(daysLate);
        }
        return sum;
    }
}