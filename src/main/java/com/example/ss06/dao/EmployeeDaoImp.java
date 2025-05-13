package com.example.ss06.dao;

import com.example.ss06.model.Employee;
import com.example.ss06.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImp implements EmployeeDao {
    @Override
    public List<Employee> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Employee> employees = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_employee()}");
            ResultSet rs = callSt.executeQuery();
            employees = new ArrayList<>();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setBirthday(rs.getDate("birthday").toLocalDate());
                employee.setPhone(rs.getString("phone"));
                employee.setEmail(rs.getString("email"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setPosition(rs.getString("position"));
                employees.add(employee);
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return employees;
    }

    @Override
    public boolean create(Employee employee) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_employee(?, ?, ?, ?, ?, ?)}");
            callSt.setString(1, employee.getName());
            callSt.setDate(2, java.sql.Date.valueOf(employee.getBirthday()));
            callSt.setString(3, employee.getPhone());
            callSt.setString(4, employee.getEmail());
            callSt.setDouble(5, employee.getSalary());
            callSt.setString(6, employee.getPosition());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public Employee findById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Employee employee = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_employee_by_id(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setBirthday(rs.getDate("birthday").toLocalDate());
                employee.setPhone(rs.getString("phone"));
                employee.setEmail(rs.getString("email"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setPosition(rs.getString("position"));
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return employee;
    }

    @Override
    public boolean update(Employee employee) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_employee(?, ?, ?, ?, ?, ?, ?)}");
            callSt.setInt(1, employee.getId());
            callSt.setString(2, employee.getName());
            callSt.setDate(3, java.sql.Date.valueOf(employee.getBirthday()));
            callSt.setString(4, employee.getPhone());
            callSt.setString(5, employee.getEmail());
            callSt.setDouble(6, employee.getSalary());
            callSt.setString(7, employee.getPosition());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_employee(?)}");
            callSt.setInt(1, id);
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }
}
