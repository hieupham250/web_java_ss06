package com.example.ss06.dao;

import com.example.ss06.model.Book;

import java.util.List;

public interface BookDao {
    List<Book> findAll();
    boolean create(Book book);
    Book findById(int id);
    boolean update(Book book);
    boolean delete(int id);
}
