package com.example.ss06.controller;import java.io.*;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "GameController", value = "/GameController")
public class GameController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/game.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userChoice = request.getParameter("choice");
        String[] choices = {"búa", "kéo", "lá"};
        Random rand = new Random();
        String computerChoice = choices[rand.nextInt(choices.length)];
        String result = determineWinner(userChoice, computerChoice);
        request.setAttribute("userChoice", userChoice);
        request.setAttribute("computerChoice", computerChoice);
        request.setAttribute("result", result);
        request.getRequestDispatcher("view/result.jsp").forward(request, response);
    }

    private String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "Hòa!";
        }
        switch (userChoice) {
            case "búa":
                return computerChoice.equals("kéo") ? "Bạn thắng!" : "Máy tính thắng!";
            case "lá":
                return computerChoice.equals("búa") ? "Bạn thắng!" : "Máy tính thắng!";
            case "kéo":
                return computerChoice.equals("giấy") ? "Bạn thắng!" : "Máy tính thắng!";
            default:
                return "Lựa chọn không hợp lệ!";
        }
    }
}