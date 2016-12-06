package com.javaweb.model.dao;


import java.sql.*;
import java.util.Properties;

public class DatabaseDAO extends DAOFactory implements BookContract {
    private static final String JDBC_DRIVER_CONFIG = "db.driver";
    private static final String DB_URL_CONFIG = "db.url";
    private static final String USERNAME_CONFIG = "db.username";
    private static final String BOOK_NAME_CONFIG = "db.book_name";

    private static final String ERROR_CREATING_CONNECTION =
            "Error, while creating connection with database %s";
    private static final String ERROR_CLOSING_CONNECTION =
            "Error, while closing connection with database";
    private static final String ERROR_SQL_QUERY_STATEMENT =
            "Error, while query sql code \"%s\"";

    private Connection connection;
    private Properties property;

    public DatabaseDAO() {
        property = getProperty();
    }

    private void createConnection() {
        String jdbcDriver = property.getProperty(JDBC_DRIVER_CONFIG);
        String dbUrl = property.getProperty(DB_URL_CONFIG);
        String username = property.getProperty(USERNAME_CONFIG);

        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(dbUrl, username, null);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.print(String.format(ERROR_CREATING_CONNECTION, dbUrl));
        }
    }

    private void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.print(ERROR_CLOSING_CONNECTION);
        }
    }

    private ResultSet getResultSetWithBook(String name) {
        ResultSet resultSet = null;
        if (connection != null) {
            try(Statement statement = connection.createStatement()) {
                resultSet = statement.executeQuery(SQL_GET_BOOK + name);
            } catch (SQLException e) {
                System.err.print(String.format(
                        ERROR_SQL_QUERY_STATEMENT, SQL_GET_BOOK + name));
            }
        }
        return resultSet;
    }

    @Override
    public String getTextOfBook() {
        createConnection();
        if (property != null) {
            String bookName = property.getProperty(BOOK_NAME_CONFIG);
            try(ResultSet resultSetWithText = getResultSetWithBook(bookName)) {
                resultSetWithText.first();
                return resultSetWithText.getString(COLUMN_BOOK_CONTENT);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        closeConnection();
        return null;
    }
}
