<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa sách</title>
</head>
<body>
<h2>Chỉnh sửa thông tin sách</h2>
<form action="<%=request.getContextPath()%>/BookController?action=Update" method="post">
    <input type="hidden" name="id" value="${book.id}" />

    <label for="title">Tiêu đề:</label><br>
    <input type="text" id="title" name="title" value="${book.title}" required><br><br>

    <label for="author">Tác giả:</label><br>
    <input type="text" id="author" name="author" value="${book.author}" required><br><br>

    <label for="genre">Thể loại:</label><br>
    <input type="text" id="genre" name="genre" value="${book.genre}" required><br><br>

    <label for="quantity">Số lượng:</label><br>
    <input type="number" id="quantity" name="quantity" value="${book.quantity}" min="0" required><br><br>

    <input type="submit" value="Update">
</form>
</body>
</html>
