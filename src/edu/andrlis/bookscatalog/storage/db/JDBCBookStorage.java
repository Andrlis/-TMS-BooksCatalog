package edu.andrlis.bookscatalog.storage.db;

import edu.andrlis.bookscatalog.entity.Author;
import edu.andrlis.bookscatalog.entity.Book;
import edu.andrlis.bookscatalog.entity.Publisher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * @author Andrei Lisouski (Andrlis) 04/03/2023 - 13:42
 */
public class JDBCBookStorage extends JDBCAbstractStorage implements DBStorage<Book> {

    //private final Connection connection;

    private JDBCAuthorStorage authorStorage;
    private JDBCPublisherStorage publisherStorage;

    public JDBCBookStorage() {
        super();
        this.authorStorage = new JDBCAuthorStorage();
        this.publisherStorage = new JDBCPublisherStorage();
    }

    @Override
    public void add(Book item) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into root.books(name, author_id, publisher_id, genre, rating) values (?,?,?,?,?)");
            preparedStatement.setString(1, item.getName());
            if (item.getAuthor().isPresent()) {
                preparedStatement.setInt(2, item.getAuthor().get().getId());
            } else {
                preparedStatement.setNull(2, Types.INTEGER);
            }
            if (item.getPublisher().isPresent()) {
                preparedStatement.setInt(3, item.getPublisher().get().getId());
            } else {
                preparedStatement.setNull(3, Types.INTEGER);
            }
            preparedStatement.setString(4, item.getGenre());
            preparedStatement.setDouble(5, item.getRating());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addWithId(Book item) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into root.books(id, name, author_id, publisher_id, genre, rating) values (?,?,?,?,?,?)");
            preparedStatement.setInt(1, item.getId());
            preparedStatement.setString(2, item.getName());
            if (item.getAuthor().isPresent()) {
                preparedStatement.setInt(3, item.getAuthor().get().getId());
            } else {
                preparedStatement.setNull(3, Types.INTEGER);
            }
            if (item.getPublisher().isPresent()) {
                preparedStatement.setInt(4, item.getPublisher().get().getId());
            } else {
                preparedStatement.setNull(4, Types.INTEGER);
            }
            preparedStatement.setString(5, item.getGenre());
            preparedStatement.setDouble(6, item.getRating());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> getAll() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from root.books");
            List<Book> bookList = new ArrayList<>();
            while (resultSet.next()) {
                bookList.add(buildBook(resultSet));
            }
            return bookList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Book> getById(int bookId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from root.books where id = ?");
            preparedStatement.setInt(1, bookId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(buildBook(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> getByName(String bookName) {
        PreparedStatement preparedStatement = null;
        try {
            List<Book> bookList = new ArrayList<>();
            preparedStatement = connection.prepareStatement("select * from root.books where lower(name) = ?");
            preparedStatement.setString(1, "'%" + bookName.toLowerCase(Locale.ROOT) + "%'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bookList.add(buildBook(resultSet));
            }
            return bookList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from root.books where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Book item) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update root.books set name = ?, author_id = ?, publisher_id = ?, genre = ?, rating = ? where id=?");
            preparedStatement.setString(1, item.getName());
            if (item.getAuthor().isPresent()) {
                preparedStatement.setInt(2, item.getAuthor().get().getId());
            } else {
                preparedStatement.setNull(2, Types.INTEGER);
            }
            if (item.getPublisher().isPresent()) {
                preparedStatement.setInt(3, item.getPublisher().get().getId());
            } else {
                preparedStatement.setNull(3, Types.INTEGER);
            }
            preparedStatement.setString(4, item.getGenre());
            preparedStatement.setDouble(5, item.getRating());
            preparedStatement.setInt(6, item.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> getByAuthor(String authorName) {
        return null;
    }

    public List<Book> getByPublisher(String publisherName) {
        return null;
    }

    public int getCount() {
        Statement statement = null;
        int count = 0;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select count(1) from root.books");
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Book buildBook(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        int authorId = resultSet.getInt(3);
        Author author = authorStorage.getById(authorId).orElse(null);   //Warning! Need to check null
        int publisherId = resultSet.getInt(4);
        Publisher publisher = publisherStorage.getById(publisherId).orElse(null); //Warning! Need to check null
        String genre = resultSet.getString(5);
        double rating = resultSet.getDouble(6);
        return new Book(id, name, author, genre, rating, publisher);
    }
}
