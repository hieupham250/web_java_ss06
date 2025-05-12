<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
<h2>Đăng nhập</h2>
<form action="LoginController" method="post">
    Tên đăng nhập: <input type="text" name="username"><br>
    Mật khẩu: <input type="password" name="password"><br>
    <input type="submit" value="Đăng nhập">
</form>
<a href="RegisterController">Chưa có tài khoản? Đăng ký tại đây</a>
</body>
</html>
