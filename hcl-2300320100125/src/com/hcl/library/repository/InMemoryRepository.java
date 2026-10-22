package com.hcl.library.repository;

import java.util.*;
import java.util.function.Function;

public class InMemoryRepository<T, ID> implements Repository<T, ID> {
    private Map<ID, T> dataMap = new HashMap<>();
    private Function<T, ID> idExtractor;

    public InMemoryRepository(Function<T, ID> idExtractor) {
        this.idExtractor = idExtractor;
    }

    @Override
    public void save(T item) {
        ID id = idExtractor.apply(item);
        dataMap.put(id, item);
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(dataMap.get(id));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(dataMap.values());
    }

    @Override
    public boolean deleteById(ID id) {
        return dataMap.remove(id) != null;
    }
}