package edu.andrlis.bookscatalog.service;

import edu.andrlis.bookscatalog.entity.Author;
import edu.andrlis.bookscatalog.entity.Publisher;

import java.util.List;
import java.util.Optional;

/**
 * @author Andrei Lisouski (Andrlis) - 26/02/2023 - 23:22
 */
public class PublisherCatalogService implements CatalogService<Publisher> {
    @Override
    public boolean validate(Publisher item) {
        return true;
    }

    @Override
    public Optional<Publisher> searchByName(String name, List<Publisher> entities) {
        for (Publisher publisher : entities) {
            if (publisher.getName().equals(name)) {
                return Optional.of(new Publisher(publisher));
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Publisher> searchById(long id, List<Publisher> entities) {
        for (Publisher publisher : entities) {
            if (publisher.getId() == id) {
                return Optional.of(new Publisher(publisher));
            }
        }
        return Optional.empty();
    }

    @Override
    public void addNewItem(Publisher item, List<Publisher> entities) {
    }

    @Override
    public void deleteItem(Publisher item, List<Publisher> entities){}
}
