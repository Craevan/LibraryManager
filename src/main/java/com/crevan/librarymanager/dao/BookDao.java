package com.crevan.librarymanager.dao;

import com.crevan.librarymanager.model.Book;

import java.util.List;

public interface BookDao {

    void addBook(Book book);

    void deleteBook(int id);

    void updateBook(Book book);

    Book getBookById(int id);

    List<Book> getAllBooks();
}
