package com.javaweb.controller;

import java.util.prefs.Preferences;

/**
 * It is good practice for storing password and username of database
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public class BookPreferences {
    /**
     * Store password and username in the {@link Preferences}
     */
    private Preferences preferences;

    /**
     * Key for username
     */
    private static final String KEY_CONFIGURATION_PATH = "configuration_path";
    /**
     * Key for password
     */
    private static final String KEY_FILE_PATH = "file_path";

    /**
     * Holder for instance of this class
     */
    private static class Holder {
        private static final BookPreferences instance =
                new BookPreferences();
    }

    /**
     * Singleton of this class
     * @return instance of class with preferences
     */
    public static BookPreferences getInstance() {
        return Holder.instance;
    }

    /**
     * Initialising file paths to preferences
     */
    private BookPreferences() {
        this.preferences = Preferences
                .userNodeForPackage(BookPreferences.class);
        putPath("D:/Studying/4Course/JavaTraining/" +
                        "ProjectsCode/Project2TextParser/src/main" +
                        "/java/com/javaweb/resources/",
                "D:/Studying/4Course/JavaTraining/ProjectsCode/" +
                        "Project2TextParser/src/main/java/com/javaweb/" +
                        "configuration/config.properties");
    }

    /**
     * Put parameters to preferences
     *
     * @param filePath path for file to read
     * @param configPath path for config to read
     */
    private void putPath(String filePath, String configPath) {
        preferences.put(KEY_FILE_PATH, filePath);
        preferences.put(KEY_CONFIGURATION_PATH, configPath);
    }

    public String getConfigurationPath() {
        return preferences.get(KEY_CONFIGURATION_PATH, null);
    }

    public String getFilePath() {
        return preferences.get(KEY_FILE_PATH, null);
    }

}
