package com.javaweb.model.dao;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileDAO extends DAOFactory {
    private String filename;

    public FileDAO(String filename) {
        this.filename = filename;
    }

    private BufferedReader getReader() {
        FileReader fir;
        try {
            fir = new FileReader(filename);
            return new BufferedReader(fir);
        } catch (FileNotFoundException e) {
            System.err.println("No such book in your path in config file!!!");
        }
        return null;
    }

    @Override
    public String getTextOfBook() {
        StringBuilder stringBuilder = new StringBuilder();
        String stringToRead;
        try(BufferedReader reader = getReader()) {
            if(reader != null) {
                while ((stringToRead = reader.readLine()) != null) {
                    stringBuilder.append(stringToRead);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
