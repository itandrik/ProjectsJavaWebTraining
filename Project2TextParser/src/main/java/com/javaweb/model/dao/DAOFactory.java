package com.javaweb.model.dao;


import com.javaweb.model.entity.Text;

import java.io.*;
import java.util.Properties;

public abstract class DAOFactory {
    protected static final String PROPERTY_PATH =
            "src/main/configuration/config.properties";
    private static final String DATA_FROM = "data.from";
    private static final String DATA_FROM_DB = "database";
    private static final String DATA_FROM_FILE = "file";
    private static final String FILE_PATH = "file.path";
    private static final String FILE_NAME = "file.name";

    public abstract String getTextOfBook();

    public static DAOFactory getDAOFactory(){
        Properties property = new Properties();
        try(FileInputStream stream = new FileInputStream(PROPERTY_PATH)){
            property.load(stream);
            if(property.getProperty(DATA_FROM,DATA_FROM_FILE).equals(DATA_FROM_FILE)){
                return new FileDAO(property.getProperty(FILE_PATH) +
                        property.getProperty(FILE_NAME));
            } else if(property.getProperty(DATA_FROM,DATA_FROM_FILE).equals(DATA_FROM_DB)){
                return new DatabaseDAO();
            }
        }
        catch (IOException ex){
            System.err.println("No config file!!!");
        }
        return null;
    }

    protected Properties getProperty(){
        Properties property = new Properties();
        try(FileInputStream stream = new FileInputStream(PROPERTY_PATH)) {
            property.load(stream);
        }catch (IOException e){
            e.printStackTrace();
        }
        return property;
    }

    public void writeTextToFile(Text text, String filename){
        try (PrintWriter out =
                     new PrintWriter(new FileWriter(new File(filename)))) {
            out.write(text.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
