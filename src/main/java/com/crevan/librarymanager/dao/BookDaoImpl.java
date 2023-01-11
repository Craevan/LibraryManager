package com.crevan.librarymanager.dao;

import com.crevan.librarymanager.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    private static final Logger log = LoggerFactory.getLogger(BookDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(book);
        log.info("Book successfully added. Book: " + book);
    }

    @Override
    public void deleteBook(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.load(Book.class, id);
        if (book != null) {
            session.delete(book);
            log.info("Book successfully removed. Book: " + book);
        } else {
            log.info("Can't find book with id = " + id);
        }
    }

    @Override
    public void updateBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
        log.info("Book successfully updated. Book: " + book);
    }

    @Override
    public Book getBookById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.load(Book.class, id);
        log.info("Book successfully loaded. Book: " + book);
        return book;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> getAllBooks() {
        Session session = sessionFactory.getCurrentSession();
        List<Book> bookList = session.createQuery("from Book ").list();
        for (Book book : bookList) {
            log.info("Book list: " + book);
        }
        return bookList;
    }
}
