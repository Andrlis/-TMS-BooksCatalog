package edu.andrlis.bookscatalog.storage.db;

import edu.andrlis.bookscatalog.entity.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * @author Andrei Lisouski (Andrlis) 04/03/2023 - 13:22
 */
public class JDBCAuthorStorage extends JDBCAbstractStorage implements DBStorage<Author> {
    //private final Connection connection;

    public JDBCAuthorStorage() {
        super();
    }

    @Override
    public void add(Author item) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into root.authors(name) values (?)");
            preparedStatement.setString(1, item.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addWithId(Author item) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into root.authors(id, name) values (?,?)");
            preparedStatement.setInt(1, item.getId());
            preparedStatement.setString(2, item.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Author> getAll() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from root.authors");
            List<Author> authorList = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Author author = new Author(id, name);
                authorList.add(author);
            }
            return authorList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Author> getById(int authorId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from root.authors where id = ?");
            preparedStatement.setInt(1, authorId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Author author = new Author(id, name);
                return Optional.of(author);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Author> getByName(String authorName) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from root.authors where lower(name) like ?");
            preparedStatement.setString(1, "'%" + authorName.toLowerCase(Locale.ROOT) + "%'");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Author> authorList = new ArrayList<>();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Author author = new Author(id, name);
                authorList.add(author);
            }
            return authorList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from root.authors where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Author item) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update root.authors set name = ? where id=?");
            preparedStatement.setString(1, item.getName());
            preparedStatement.setInt(2, item.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
