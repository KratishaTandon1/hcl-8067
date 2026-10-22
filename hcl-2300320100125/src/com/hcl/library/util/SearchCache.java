package com.hcl.library.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class SearchCache<K, V> extends LinkedHashMap<K, V> {
    private int cacheLimit;

    public SearchCache(int cacheLimit) {
        super(cacheLimit, 0.75f, true);
        this.cacheLimit = cacheLimit;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheLimit;
    }
}