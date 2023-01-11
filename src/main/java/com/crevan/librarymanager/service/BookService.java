package com.crevan.librarymanager.service;

import com.crevan.librarymanager.model.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    void deleteBook(int id);

    void updateBook(Book book);

    Book getBookById(int id);

    List<Book> getAllBooks();
}
