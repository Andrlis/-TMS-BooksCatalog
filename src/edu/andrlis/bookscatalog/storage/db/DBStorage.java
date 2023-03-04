package edu.andrlis.bookscatalog.storage.db;

import java.util.List;
import java.util.Optional;

/**
 * @author Andrei Lisouski (Andrlis) 04/03/2023 - 13:28
 */
public interface DBStorage<T> {

    void add(T item);

    List<T> getAll();

    Optional<T> getById(long id);

    List<T> getByName(String name);

    void deleteById(long id);

    void update(T item);
}
