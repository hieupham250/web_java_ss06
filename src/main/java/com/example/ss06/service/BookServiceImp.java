package com.example.ss06.service;

import com.example.ss06.dao.BookDao;
import com.example.ss06.dao.BookDaoImp;
import com.example.ss06.model.Book;

import java.util.List;

public class BookServiceImp implements BookService {
    private final BookDao bookDao;

    public BookServiceImp() {
        bookDao = new BookDaoImp();
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public boolean create(Book book) {
        return bookDao.create(book);
    }

    @Override
    public Book findById(int id) {
        return bookDao.findById(id);
    }

    @Override
    public boolean update(Book book) {
        return bookDao.update(book);
    }

    @Override
    public boolean delete(int id) {
        return bookDao.delete(id);
    }
}
