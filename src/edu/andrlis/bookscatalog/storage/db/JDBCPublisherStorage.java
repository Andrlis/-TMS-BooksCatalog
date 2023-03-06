package edu.andrlis.bookscatalog.storage.db;

import edu.andrlis.bookscatalog.entity.Publisher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * @author Andrei Lisouski (Andrlis) 04/03/2023 - 13:41
 */
public class JDBCPublisherStorage extends JDBCAbstractStorage implements DBStorage<Publisher> {
    //private final Connection connection;

    public JDBCPublisherStorage() {
        super();
    }

    @Override
    public void add(Publisher item) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into root.publishers(name) values (?)");
            preparedStatement.setString(1, item.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addWithId(Publisher item) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into root.publishers(id, name) values (?,?)");
            preparedStatement.setInt(1, item.getId());
            preparedStatement.setString(2, item.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Publisher> getAll() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from root.publishers");
            List<Publisher> publisherList = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Publisher publisher = new Publisher(id, name);
                publisherList.add(publisher);
            }
            return publisherList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Publisher> getById(int publisherId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from root.publishers where id = ?");
            preparedStatement.setInt(1, publisherId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Publisher publisher = new Publisher(id, name);
                return Optional.of(publisher);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Publisher> getByName(String publisherName) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from root.publishers where lower(name) like ?");
            preparedStatement.setString(1, "'%" + publisherName.toLowerCase(Locale.ROOT) + "%'");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Publisher> publisherList = new ArrayList<>();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Publisher publisher = new Publisher(id, name);
                publisherList.add(publisher);
            }
            return publisherList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from root.publishers where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Publisher item) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update root.publishers set name = ? where id=?");
            preparedStatement.setString(1, item.getName());
            preparedStatement.setInt(2, item.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
