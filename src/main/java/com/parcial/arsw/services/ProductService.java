package com.parcial.arsw.services;

import org.springframework.stereotype.Service;

import com.parcial.arsw.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductService {

    private final ConcurrentMap<Long, Product> store = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<Product> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Product create(Product p) {
        long id = idGenerator.getAndIncrement();
        p.setId(id);
        store.put(id, p);
        return p;
    }

    public Optional<Product> update(Long id, Product p) {
        return Optional.ofNullable(store.computeIfPresent(id, (k, old) -> {
            old.setName(p.getName());
            old.setDescription(p.getDescription());
            return old;
        }));
    }

    public boolean delete(Long id) {
        return store.remove(id) != null;
    }
}
