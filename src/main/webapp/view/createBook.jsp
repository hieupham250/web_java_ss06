<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sách mới</title>
</head>
<body>
<h2>Thêm sách mới</h2>
<form action="<%=request.getContextPath()%>/BookController?action=Create" method="post">

    <label for="title">Tiêu đề:</label><br>
    <input type="text" id="title" name="title" required><br><br>

    <label for="author">Tác giả:</label><br>
    <input type="text" id="author" name="author" required><br><br>

    <label for="genre">Thể loại:</label><br>
    <input type="text" id="genre" name="genre" required><br><br>

    <label for="quantity">Số lượng:</label><br>
    <input type="number" id="quantity" name="quantity" min="0" required><br><br>

    <input type="submit" value="Create">
</form>
</body>
</html>
