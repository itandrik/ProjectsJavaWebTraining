package com.javaweb.view;

/**
 * View.java
 * <p>
 * It is class, which contains String constants
 * in order to show tips for user in the console.
 * In the future we can change UI by simple steps.
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public class View {
    /**
     * Path for config file
     */
    public static final String PROPERTY_PATH =
            "D:/Studying/4Course/JavaTraining/ProjectsCode/" +
                    "Project2TextParser/src/main/java/com/javaweb/" +
                    "configuration/config.properties";

    /* Here are some strings for getting information from config file */
    public static final String PROPERTY_FILE_PATH =
            "file.path";
    public static final String PROPERTY_FILE_OUTPUT_NAME =
            "file.name.output";
    /**
     * Tip that text has been parsed
     */
    public static final String TEXT_PARSED =
            "Book '%s' has been successfully parsed!!";
    /**
     * Tip that DOM has been written
     */
    public static final String TEXT_WRITTEN_TO_FILE =
            "DOM model of book \'%s\' has been successfully written to file %s!!";
    /**
     * Show sorted list
     */
    public static final String SORTED_LIST =
            "Sorted list of words with first vowel letter";

    /*
     * It is better to store password and username for database
     * not in the config file. But we work only with console,
     * so it is impossible to read secure from it.
     * Here are tips for it.
     */
    public static final String DB_USERNAME = "Enter username for db";
    public static final String DB_PASSWORD = "Enter password for db";


    /**
     * @param message - array of strings for printing to console without next line symbol.
     */
    public void printMessage(Object... message) {
        for (Object str : message) {
            System.out.print(str);
        }
    }

    /**
     * @param message - array of strings for printing to console with next line symbol.
     */
    public void printlnMessage(Object... message) {
        for (Object str : message) {
            System.out.println(str);
        }
    }
}
