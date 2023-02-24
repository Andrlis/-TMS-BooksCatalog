package edu.andrlis.bookscatalog.service;


import java.util.List;
import java.util.Optional;

/**
 * @author Andrei Lisouski (Andrlis) - 24/02/2023 - 2:06
 */
public interface CatalogService<T> {
    boolean validate(T item);

    Optional<T> searchByName(String name, List<T> entities);

    Optional<T> searchById(long id, List<T> entities);

    void addNewItem(T item, List<T> entities);
}
