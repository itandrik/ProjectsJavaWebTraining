package com.javaweb.model.dao.impl;


import com.javaweb.model.dao.BookContract;
import com.javaweb.model.dao.DAOFactory;
import com.javaweb.model.dao.IDatabaseDAO;

import java.sql.*;
import java.util.Properties;

/**
 * DAO, that gets text from database.
 * Here are some basic methods of working
 * with MySql database.
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public class DatabaseDAO extends DAOFactory implements IDatabaseDAO, BookContract {
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
    public void createConnection() {
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
    public void closeConnection() {
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
