package com.javaweb.model.dao;

/**
 * Interface, that describes DAO factory
 *
 * @author Andrii Chernysh
 */
public interface IFactoryDAO {
    /**
     * Gets text from book. From file or database
     *
     * @return string with text in the book
     */
    String getTextOfBook();

    /**
     * Uses for pretty view in the controller
     *
     * @return string with file name from file or database
     */
    String getInputFileName();
}
