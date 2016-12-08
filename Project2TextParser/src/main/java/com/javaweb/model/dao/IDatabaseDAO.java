package com.javaweb.model.dao;

/**
 * Interface, that describes DAO for file input
 *
 * @author Andrii Chernysh
 */
public interface IDatabaseDAO extends IFactoryDAO {
    /* Here are some strings for getting information from config file */
    String JDBC_DRIVER_CONFIG = "db.driver";
    String DB_URL_CONFIG = "db.url";

    /**
     * It is better to store password and username for database
     * not in the config file. But we work only with console,
     * so it is impossible to read secure from it.
     */
    String USERNAME_CONFIG = "db.username";
    String PASSWORD_CONFIG = "db.password";
    String BOOK_NAME_CONFIG = "db.book_name";

    /* Strings for errors for working with database */
    String ERROR_CREATING_CONNECTION =
            "Error, while creating connection with database %s";
    String ERROR_CLOSING_CONNECTION =
            "Error, while closing connection with database";
    String ERROR_SQL_QUERY_STATEMENT =
            "Error, while query sql code \"%s\"";

    /**
     * Creating connection with database
     */
    void createConnection();

    /**
     * Closing connection with database
     */
    void closeConnection();
}
