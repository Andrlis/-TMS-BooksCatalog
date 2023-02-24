package edu.andrlis.bookscatalog.service;

import edu.andrlis.bookscatalog.entity.Author;

import java.util.List;
import java.util.Optional;

/**
 * @author Andrei Lisouski (Andrlis) - 24/02/2023 - 2:42
 */
public class AuthorCatalogService implements CatalogService<Author> {
    @Override
    public boolean validate(Author item) {
        return true;
    }

    @Override
    public Optional<Author> searchByName(String name, List<Author> entities) {
        for (Author author : entities) {
            if (author.getName().equals(name)) {
                return Optional.of(new Author(author));
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Author> searchById(long id, List<Author> entities) {
        for (Author author : entities) {
            if (author.getId() == id) {
                return Optional.of(new Author(author));
            }
        }
        return Optional.empty();
    }

    @Override
    public void addNewItem(Author item, List<Author> entities) {
    }
}
