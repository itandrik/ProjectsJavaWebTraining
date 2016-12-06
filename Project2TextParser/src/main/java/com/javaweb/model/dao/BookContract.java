package com.javaweb.model.dao;


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

    String SQL_GET_BOOK =
            "SELECT " + COLUMN_BOOK_CONTENT + " FROM " +
                    TABLE_NAME_BOOK + " WHERE " + COLUMN_BOOK_NAME +
                    "=";

}
