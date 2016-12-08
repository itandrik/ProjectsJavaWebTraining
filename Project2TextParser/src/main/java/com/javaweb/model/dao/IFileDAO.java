package com.javaweb.model.dao;

import java.io.BufferedReader;

/**
 * Interface, that describes DAO for file input
 *
 * @author Andrii Chernysh
 */
public interface IFileDAO extends IFactoryDAO {
    /**
     * Error of filename for book. Invalid filename
     */
    String ERROR_NO_SUCH_BOOK =
            "No such book in your path in config file!!!";

    /**
     * @return reader instance
     */
    BufferedReader getReader();
}
