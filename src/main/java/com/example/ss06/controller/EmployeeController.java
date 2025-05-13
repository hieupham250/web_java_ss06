package com.example.ss06.controller;

import com.example.ss06.model.Employee;
import com.example.ss06.service.EmployeeService;
import com.example.ss06.service.EmployeeServiceImp;

import java.io.*;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "EmployeeController", value = "/EmployeeController")
public class EmployeeController extends HttpServlet {
    private final EmployeeService employeeService;

    public EmployeeController() {
        employeeService = new EmployeeServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("findAll")) {
            findAllEmployee(request, response);
        } else if (action.equals("initUpdate")) {
            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            Employee employee = employeeService.findById(employeeId);
            if (employee != null) {
                request.setAttribute("employee", employee);
                request.getRequestDispatcher("view/updateEmployee.jsp").forward(request, response);
            }
        } else if (action.equals("delete")) {
            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            boolean result = employeeService.delete(employeeId);
            redirectBasedOnResult(result, request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("Create")) {
            Employee employee = new Employee();
            employee.setName(request.getParameter("name"));
            employee.setBirthday(LocalDate.parse(request.getParameter("birthday")));
            employee.setPhone(request.getParameter("phone"));
            employee.setEmail(request.getParameter("email"));
            employee.setSalary(Double.parseDouble(request.getParameter("salary")));
            employee.setPosition(request.getParameter("position"));
            boolean result = employeeService.create(employee);
            redirectBasedOnResult(result, request, response);
        } else if (action.equals("Update")) {
            Employee employee = new Employee();
            employee.setId(Integer.parseInt(request.getParameter("id")));
            employee.setName(request.getParameter("name"));
            employee.setBirthday(LocalDate.parse(request.getParameter("birthday")));
            employee.setPhone(request.getParameter("phone"));
            employee.setEmail(request.getParameter("email"));
            employee.setSalary(Double.parseDouble(request.getParameter("salary")));
            employee.setPosition(request.getParameter("position"));
            boolean result = employeeService.update(employee);
            redirectBasedOnResult(result, request, response);
        }
    }

    public void findAllEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> listEmployees = employeeService.findAll();
        request.setAttribute("listEmployees", listEmployees);
        request.getRequestDispatcher("view/employeeList.jsp").forward(request, response);
    }

    private void redirectBasedOnResult(boolean result, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (result) {
            findAllEmployee(request, response);
        } else {
            request.getRequestDispatcher("view/error.jsp").forward(request, response);
        }
    }
}