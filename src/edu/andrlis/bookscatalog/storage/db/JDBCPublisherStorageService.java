package edu.andrlis.bookscatalog.storage.db;

import edu.andrlis.bookscatalog.entity.Publisher;

import java.util.List;
import java.util.Optional;

/**
 * @author Andrei Lisouski (Andrlis) 04/03/2023 - 13:41
 */
public class JDBCPublisherStorageService implements DBStorage<Publisher> {
    @Override
    public void add(Publisher item) {

    }

    @Override
    public List<Publisher> getAll() {
        return null;
    }

    @Override
    public Optional<Publisher> getById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Publisher> getByName(String name) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void update(Publisher item) {

    }
}
