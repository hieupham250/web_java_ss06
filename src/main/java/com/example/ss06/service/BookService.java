package com.example.ss06.service;

import com.example.ss06.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    boolean create(Book book);
    Book findById(int id);
    boolean update(Book book);
    boolean delete(int id);
}
