package com.aboydfd.infrastructure;

import com.aboydfd.domain.Entity;
import com.aboydfd.domain.Repository;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

public class RepositoryMemoryAdapter<E extends Entity<I>, I> implements Repository<E, I> {
    Map<I, E> map = newHashMap();

    @Override
    public E save(E entity) {
        return map.put(entity.getId(), entity);
    }

    @Override
    public E findById(I id) {
        return map.get(id);
    }
}
