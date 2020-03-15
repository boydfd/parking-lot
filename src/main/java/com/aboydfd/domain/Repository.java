package com.aboydfd.domain;

public interface Repository<E, I> {
    E save(E entity);

    E findById(I id);
}
