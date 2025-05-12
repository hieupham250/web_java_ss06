package com.example.ss06.controller;

import com.example.ss06.service.UserService;
import com.example.ss06.service.UserServiceImp;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "RegisterController", value = "/RegisterController")
public class RegisterController extends HttpServlet {
    private final UserService userService;

    public RegisterController() {
        userService = new UserServiceImp();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("view/register.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        boolean result = userService.registerUser(username, password, email, phone);
        if (result) {
            resp.sendRedirect(req.getContextPath() + "/LoginController");
        } else {
            req.setAttribute("error", "Đăng ký thất bại. Vui lòng thử lại.");
            req.getRequestDispatcher("view/register.jsp").forward(req, resp);
        }
    }
}