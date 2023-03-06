package edu.andrlis.bookscatalog.storage.db;

import java.util.List;
import java.util.Optional;

/**
 * @author Andrei Lisouski (Andrlis) 04/03/2023 - 13:28
 */
public interface DBStorage<T> {

    void add(T item);

    void addWithId(T item);

    List<T> getAll();

    Optional<T> getById(int id);

    List<T> getByName(String name);

    void deleteById(int id);

    void update(T item);
}
