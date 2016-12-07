package com.javaweb.controller;

import java.util.prefs.Preferences;

/**
 * It is good practice for storing password and username of database
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public class DatabaseConfigurator {
    /**
     * Store password and username in the {@link Preferences}
     */
    private Preferences preferences =
            Preferences.userNodeForPackage(DatabaseConfigurator.class);
    /**
     * Key for username
     */
    private static final String KEY_USERNAME = "db_username";
    /**
     * Key for password
     */
    private static final String KEY_PASSWORD = "db_password";

    /**
     * Save parameters
     *
     * @param username username
     * @param password password
     */
    public void setCredentials(String username, String password) {
        preferences.put(KEY_USERNAME, username);
        preferences.put(KEY_PASSWORD, password);
    }

    public String getUsername() {
        return preferences.get(KEY_USERNAME, null);
    }

    public String getPassword() {
        return preferences.get(KEY_PASSWORD, null);
    }

}
