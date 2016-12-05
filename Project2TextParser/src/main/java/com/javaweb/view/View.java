package com.javaweb.view;


public class View {
    public static final String FILENAME =
            "D:/Studying/4Course/JavaTraining/ProjectsCode/" +
                    "Project2TextParser/src/main/java/" +
                    "com/javaweb/resources/programming_book.txt";
    public static final String OUTPUT_FILENAME =
            "D:/Studying/4Course/JavaTraining/ProjectsCode/" +
                    "Project2TextParser/src/main/java/" +
                    "com/javaweb/resources/parsed_programming_book.txt";

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
