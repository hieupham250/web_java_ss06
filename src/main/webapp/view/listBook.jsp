<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sách</title>
</head>
<body>
<h3>Danh sách sách</h3>
<table border="1">
    <thead>
    <th>mã sách</th>
    <th>tiêu đề</th>
    <th>tác giả</th>
    <th>thể loại</th>
    <th>số lượng</th>
    <th>chức năng</th>
    </thead>
    <tbody>
    <c:forEach items="${listBooks}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.genre}</td>
            <td>${book.quantity}</td>
            <td>
                <a href="<%=request.getContextPath()%>/BookController?bookId=${book.id}&&action=initUpdate">Update</a>
                <a href="<%=request.getContextPath()%>/BookController?bookId=${book.id}&&action=delete">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="view/createBook.jsp">thêm sách mới</a>
</body>
</html>
