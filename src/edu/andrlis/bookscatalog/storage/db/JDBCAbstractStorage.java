package edu.andrlis.bookscatalog.storage.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Andrei Lisouski (Andrlis) - 06/03/2023 - 2:38
 */
public abstract class JDBCAbstractStorage {
    public final Connection connection;

    public JDBCAbstractStorage() {
        try {
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/book_catalog_db", "postgres", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection(){
        return this.connection;
    }
}
