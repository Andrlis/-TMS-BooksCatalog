package edu.andrlis.bookscatalog.service.file;

import edu.andrlis.bookscatalog.entity.Book;

import java.util.List;
import java.util.Optional;

/**
 * @author Andrei Lisouski (Andrlis) - 26/02/2023 - 23:24
 */
public class BookCatalogService implements FileCatalogService<Book> {
    @Override
    public boolean validate(Book item) {
        return true;
    }

    @Override
    public Optional<Book> searchByName(String name, List<Book> entities) {
        for (Book book : entities) {
            if (book.getName().equals(name)) {
                return Optional.of(new Book(book));
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Book> searchById(long id, List<Book> entities) {
        for (Book book : entities) {
            if (book.getId() == id) {
                return Optional.of(new Book(book));
            }
        }
        return Optional.empty();
    }

    @Override
    public void addNewItem(Book item, List<Book> entities) {
    }

    @Override
    public void deleteItem(Book item, List<Book> entities){}
}
