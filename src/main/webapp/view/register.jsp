<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng ký</title>
</head>
<body>
<h2>Đăng ký</h2>
<form action="RegisterController" method="post">
    Tên đăng nhập: <input type="text" name="username"><br>
    Mật khẩu: <input type="password" name="password"><br>
    Email: <input type="email" name="email"><br>
    Số điện thoại: <input type="text" name="phone"><br>
    <input type="submit" value="Đăng ký">
</form>
<a href="LoginController">Đã có tài khoản? Đăng nhập tại đây</a>
</body>
</html>
