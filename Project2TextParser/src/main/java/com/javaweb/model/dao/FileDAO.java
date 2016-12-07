package com.javaweb.model.dao;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * FileDAO.java
 * <t>
 * DAO, that gets text from file.
 * Here are some basic methods of working
 * with {@link BufferedReader}.
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public class FileDAO extends DAOFactory {
    /**
     * Name of file
     */
    private String filename;
    /**
     * Error of filename for book. Invalid filename
     */
    private static final String ERROR_NO_SUCH_BOOK =
            "No such book in your path in config file!!!";

    /**
     * Default constructor
     *
     * @param filename name of file to read
     */
    public FileDAO(String filename) {
        this.filename = filename;
    }

    /**
     * @return {@link BufferedReader} instance for some book
     */
    private BufferedReader getReader() {
        FileReader fir;
        try {
            fir = new FileReader(filename);
            return new BufferedReader(fir);
        } catch (FileNotFoundException e) {
            System.err.println(ERROR_NO_SUCH_BOOK);
        }
        return null;
    }

    /**
     * @return name of file, that needs to read
     */
    @Override
    public String getInputFileName() {
        return getProperty().getProperty(FILE_NAME);
    }

    /**
     * Getting text of book with special name
     *
     * @return text of book
     */
    @Override
    public String getTextOfBook() {
        //Uses for programs' speed
        StringBuilder stringBuilder = new StringBuilder();
        String stringToRead;
        try (BufferedReader reader = getReader()) {
            if (reader != null) {
                while ((stringToRead = reader.readLine()) != null) {
                    stringBuilder.append(stringToRead);
                }
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
