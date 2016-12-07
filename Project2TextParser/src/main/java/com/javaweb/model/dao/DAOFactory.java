package com.javaweb.model.dao;


import com.javaweb.model.entity.Text;

import java.io.*;
import java.util.Properties;

/**
 * Factory for pattern 'Data Access Object'. Here are choosing of
 * file input or database input, using config file.
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public abstract class DAOFactory {
    /**
     * Path for config file
     */
    protected static final String PROPERTY_PATH =
            "D:/Studying/4Course/JavaTraining/ProjectsCode/" +
                    "Project2TextParser/src/main/java/com/javaweb/" +
                    "configuration/config.properties";

    /* Here are some strings for getting information from config file */
    private static final String DATA_FROM = "data.from";
    private static final String DATA_FROM_DB = "database";
    private static final String DATA_FROM_FILE = "file";
    private static final String FILE_PATH = "file.path";
    protected static final String FILE_NAME = "file.name";
    private static final String ERROR_NO_FILE =
            "No config file!!!";

    /**
     * Gets text from book. From file or database
     *
     * @return string with text in the book
     */
    public abstract String getTextOfBook();

    /**
     * Uses for pretty view in the controller
     *
     * @return string with file name from file or database
     */
    public abstract String getInputFileName();

    /**
     * It creates instance of DAO according to config file
     *
     * @return DAO from file {@link FileDAO} or DAO from Database {@link DatabaseDAO}
     */
    public static DAOFactory getDAOFactory() {
        Properties property = new Properties();
        try (FileInputStream stream = new FileInputStream(PROPERTY_PATH)) {
            property.load(stream);
            if (property.getProperty(
                    DATA_FROM, DATA_FROM_FILE).equals(DATA_FROM_FILE)) {
                return new FileDAO(property.getProperty(FILE_PATH) + //From file
                        property.getProperty(FILE_NAME));
            } else if (property.getProperty(
                    DATA_FROM, DATA_FROM_FILE).equals(DATA_FROM_DB)) {
                return new DatabaseDAO();                                   //From database
            }
        } catch (IOException ex) {
            System.err.println(ERROR_NO_FILE);          // No such file
        }
        return null;
    }

    /**
     * Gets special property from config file
     *
     * @return property instance
     */
    protected Properties getProperty() {
        Properties property = new Properties();
        try (FileInputStream stream = new FileInputStream(PROPERTY_PATH)) {
            property.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }

    /**
     * Writes DOM model to special file
     *
     * @param text     root of DOM model
     * @param filename name of file, where to write
     */
    public void writeTextToFile(Text text, String filename) {
        try (PrintWriter out =
                     new PrintWriter(new FileWriter(new File(filename)))) {
            out.write(text.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
