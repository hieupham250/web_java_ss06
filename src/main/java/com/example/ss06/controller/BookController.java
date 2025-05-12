package com.example.ss06.controller;

import com.example.ss06.model.Book;
import com.example.ss06.service.BookService;
import com.example.ss06.service.BookServiceImp;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "BookController", value = "/BookController")
public class BookController extends HttpServlet {
    private final BookService bookService;

    public BookController() {
        bookService = new BookServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("findAll")) {
            findAllBook(request, response);
        } else if (action.equals("initUpdate")) {
            int bookId = Integer.parseInt(request.getParameter("bookId"));
            Book book = bookService.findById(bookId);
            if (book != null) {
                request.setAttribute("book", book);
                request.getRequestDispatcher("view/updateBook.jsp").forward(request, response);
            }
        } else if (action.equals("delete")) {
            int bookId = Integer.parseInt(request.getParameter("bookId"));
            boolean result = bookService.delete(bookId);
            redirectBasedOnResult(result, request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("Create")) {
            Book book = new Book();
            book.setTitle(request.getParameter("title"));
            book.setAuthor(request.getParameter("author"));
            book.setGenre(request.getParameter("genre"));
            book.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            boolean result = bookService.create(book);
            redirectBasedOnResult(result, request, response);
        } else if (action.equals("Update")) {
            Book book = new Book();
            book.setId(Integer.parseInt(request.getParameter("id")));
            book.setTitle(request.getParameter("title"));
            book.setAuthor(request.getParameter("author"));
            book.setGenre(request.getParameter("genre"));
            book.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            boolean result = bookService.update(book);
            redirectBasedOnResult(result, request, response);
        }
    }

    public void findAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> listBooks = bookService.findAll();
        request.setAttribute("listBooks", listBooks);
        request.getRequestDispatcher("view/listBook.jsp").forward(request, response);
    }

    private void redirectBasedOnResult(boolean result, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (result) {
            findAllBook(request, response);
        } else {
            request.getRequestDispatcher("view/error.jsp").forward(request, response);
        }
    }
}