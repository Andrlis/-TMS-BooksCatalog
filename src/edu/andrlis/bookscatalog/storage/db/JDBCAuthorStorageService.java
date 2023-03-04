package edu.andrlis.bookscatalog.storage.db;

import edu.andrlis.bookscatalog.entity.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Andrei Lisouski (Andrlis) 04/03/2023 - 13:22
 */
public class JDBCAuthorStorageService implements DBStorage<Author> {

    @Override
    public void add(Author item){

    }

    @Override
    public List<Author> getAll(){
        return new ArrayList<>();
    }

    @Override
    public Optional<Author> getById(long id){
        return Optional.empty();
    }

    @Override
    public List<Author> getByName(String name){
        return new ArrayList<>();
    }

    @Override
    public void deleteById(long id){

    }

    public void update(Author item){

    }
}
