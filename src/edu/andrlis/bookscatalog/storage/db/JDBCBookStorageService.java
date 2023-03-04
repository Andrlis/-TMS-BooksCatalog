package edu.andrlis.bookscatalog.storage.db;

import edu.andrlis.bookscatalog.entity.Book;

import java.util.List;
import java.util.Optional;

/**
 * @author Andrei Lisouski (Andrlis) 04/03/2023 - 13:42
 */
public class JDBCBookStorageService implements DBStorage<Book> {
    @Override
    public void add(Book item) {

    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public Optional<Book> getById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Book> getByName(String name) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void update(Book item) {

    }

    public List<Book> getByAuthor(String authorName){
        return null;
    }

    public List<Book> getByPublisher(String publisherName){
        return null;
    }
}
