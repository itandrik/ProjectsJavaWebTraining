package com.javaweb.model.dao;


import java.sql.*;
import java.util.Properties;

/**
 * DatabaseDAO.java
 * <t>
 * DAO, that gets text from database.
 * Here are some basic methods of working
 * with MySql database.
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public class DatabaseDAO extends DAOFactory implements BookContract {
    /* Here are some strings for getting information from config file */
    private static final String JDBC_DRIVER_CONFIG = "db.driver";
    private static final String DB_URL_CONFIG = "db.url";

    /**
     * It is better to store password and username for database
     * not in the config file. But we work only with console,
     * so it is impossible to read secure from it.
     */
    private static final String USERNAME_CONFIG = "db.username";
    private static final String PASSWORD_CONFIG = "db.password";
    private static final String BOOK_NAME_CONFIG = "db.book_name";

    /* Strings for errors for working with database */
    private static final String ERROR_CREATING_CONNECTION =
            "Error, while creating connection with database %s";
    private static final String ERROR_CLOSING_CONNECTION =
            "Error, while closing connection with database";
    private static final String ERROR_SQL_QUERY_STATEMENT =
            "Error, while query sql code \"%s\"";

    /**
     * Connection instance
     */
    private Connection connection;
    /**
     * Property instance
     */
    private Properties property;
    /**
     * Statement instance
     */
    private Statement statement;

    public DatabaseDAO() {
        property = getProperty();
    }

    /**
     * Creating connection with database
     */
    private void createConnection() {
        String jdbcDriver = property.getProperty(JDBC_DRIVER_CONFIG);
        String dbUrl = property.getProperty(DB_URL_CONFIG);
        String username = property.getProperty(USERNAME_CONFIG);
        String password = property.getProperty(PASSWORD_CONFIG);
        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.print(String.format(ERROR_CREATING_CONNECTION, dbUrl));
        }
    }

    /**
     * Closing connection with database
     */
    private void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.print(ERROR_CLOSING_CONNECTION);
        }
    }

    /**
     * Getting result set of querying from database
     *
     * @param name name of book
     * @return {@link ResultSet} with text from book
     */
    private ResultSet getResultSetWithBook(String name) {
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(String.format(SQL_GET_BOOK, name));
            } catch (SQLException e) {
                System.err.print(String.format(
                        ERROR_SQL_QUERY_STATEMENT, String.format(SQL_GET_BOOK, name)));
            }
        }
        return resultSet;
    }

    /**
     * Getting name of book from database
     *
     * @return name of book
     */
    @Override
    public String getInputFileName() {
        return property.getProperty(BOOK_NAME_CONFIG);
    }

    /**
     * Getting text of book with special name
     *
     * @return text of book
     */
    @Override
    public String getTextOfBook() {
        createConnection();
        if (property != null) {
            String bookName = property.getProperty(BOOK_NAME_CONFIG);
            try (ResultSet resultSetWithText = getResultSetWithBook(bookName)) {
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
