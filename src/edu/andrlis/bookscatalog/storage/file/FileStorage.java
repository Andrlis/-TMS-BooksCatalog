package edu.andrlis.bookscatalog.storage.file;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Andrei Lisouski (Andrlis)
 * @created 12/02/2023 - 23:54
 */
public interface FileStorage<T> {

    void save(T item);

    void save(List<T> listOfItems);

    List<T> getAll(Type type);

}
