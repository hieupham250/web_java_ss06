<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách nhân viên</title>
</head>
<body>
<h3>Danh sách nhân viên</h3>
<table border="1">
    <thead>
        <th>mã nhân viên</th>
        <th>tên</th>
        <th>ngày sinh</th>
        <th>số điện thoại</th>
        <th>email</th>
        <th>lương</th>
        <th>chức vụ</th>
        <th>chức năng</th>
    </thead>
    <tbody>
    <c:forEach items="${listEmployees}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.birthday}</td>
            <td>${employee.phone}</td>
            <td>${employee.email}</td>
            <td>${employee.salary}</td>
            <td>${employee.position}</td>
            <td>
                <a href="<%=request.getContextPath()%>/EmployeeController?employeeId=${employee.id}&&action=initUpdate">Update</a>
                <a href="<%=request.getContextPath()%>/EmployeeController?employeeId=${employee.id}&&action=delete">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="view/createEmployee.jsp">thêm nhân viên mới</a>
</body>
</html>
