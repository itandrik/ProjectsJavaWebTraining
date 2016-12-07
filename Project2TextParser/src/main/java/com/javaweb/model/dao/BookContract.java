package com.javaweb.model.dao;

/**
 * BookContract.java
 * <t>
 * It is good practice to show structure of database
 * in the 'contract' class. Here are name of tables and
 * columns of these tables. Also here are sql queries.
 *
 * @author Andrii Chernysh
 * @version 1.0, 07 Dec 2016
 */
public interface BookContract {
    String TABLE_NAME_AUTHOR = "author";
    String TABLE_NAME_BOOK = "book";

    String COLUMN_ID = "id";
    String COLUMN_BOOK_AUTHOR_ID = "author_id";
    String COLUMN_BOOK_CONTENT = "content";
    String COLUMN_BOOK_NAME = "name";

    String COLUMN_AUTHOR_FIRST_NAME = "first_name";
    String COLUMN_AUTHOR_SECOND_NAME = "second_name";
    String COLUMN_AUTHOR_PHONE_NUMBER = "phone_number";

    /**
     * SELECT text_from_book FROM database_name.book
     * WHERE name=name_of_book;
     */
    String SQL_GET_BOOK =
            "SELECT " + COLUMN_BOOK_CONTENT + " FROM " +
                    TABLE_NAME_BOOK + " WHERE " + COLUMN_BOOK_NAME +
                    "=\'%s\';";

}
