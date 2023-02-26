package edu.andrlis.bookscatalog.storage;

import edu.andrlis.bookscatalog.entity.AbstractCatalogItem;
import edu.andrlis.bookscatalog.entity.Book;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Andrei Lisouski (Andrlis)
 * @created 12/02/2023 - 23:54
 */
public interface Storable<T> {

    void save(T item);

    void save(List<T> listOfItems);

    List<T> getAll(Type type);

}
