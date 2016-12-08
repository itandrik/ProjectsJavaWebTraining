package com.javaweb.model.dao;


import com.javaweb.controller.BookPreferences;
import com.javaweb.model.dao.impl.DatabaseDAO;
import com.javaweb.model.dao.impl.FileDAO;
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
public abstract class DAOFactory implements IFactoryDAO {
    /**
     * Preferences with paths to file for
     * parsing and to configuration file
     */
    private static BookPreferences preferences = BookPreferences.getInstance();

    /* Here are some strings for getting information from config file */
    private static final String DATA_FROM = "data.from";
    private static final String DATA_FROM_DB = "database";
    private static final String DATA_FROM_FILE = "file";
    protected static final String FILE_NAME = "file.name";
    private static final String ERROR_NO_FILE =
            "No config file!!!";

    /**
     * It creates instance of DAO according to config file
     *
     * @return DAO from file {@link FileDAO} or DAO from Database {@link DatabaseDAO}
     */
    public static DAOFactory getDAOFactory() {
        Properties property = new Properties();
        try (FileInputStream stream = new FileInputStream(
                preferences.getConfigurationPath())) {
            property.load(stream);
            if (property.getProperty(
                    DATA_FROM, DATA_FROM_FILE).equals(DATA_FROM_FILE)) {
                return new FileDAO(preferences.getFilePath() + //From file
                        property.getProperty(FILE_NAME));
            } else if (property.getProperty(
                    DATA_FROM, DATA_FROM_FILE).equals(DATA_FROM_DB)) {
                return new DatabaseDAO();               //From database
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
        try (FileInputStream stream = new FileInputStream(
                BookPreferences.getInstance().getConfigurationPath())) {
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
