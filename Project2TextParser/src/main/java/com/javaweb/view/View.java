package com.javaweb.view;


public class View {
    public static final String PROPERTY_PATH =
            "src/main/configuration/config.properties";
    public static final String PROPERTY_FILE_PATH =
            "file.path";
    public static final String PROPERTY_FILE_OUTPUT_NAME =
            "file.name.output";
    public static final String TEXT_PARSED =
            "Book %s has been successfully parsed!!";
    public static final String TEXT_WRITTEN_TO_FILE =
            "Book %s has been successfully written to file!!";

    /**
     * @param message - array of strings for printing
     *                to console without next line symbol.
     */
    public void printMessage(Object... message) {
        for (Object str : message) {
            System.out.print(str);
        }
    }

    /**
     * @param message - array of strings for printing
     *                to console with next line symbol.
     */
    public void printlnMessage(Object... message) {
        for (Object str : message) {
            System.out.println(str);
        }
    }
}
