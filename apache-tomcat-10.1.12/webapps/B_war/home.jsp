<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录成功</title>
    <link rel="stylesheet" href="css/home.css">
</head>
<body>
<div class="container">
    <h3>登录成功！</h3>
    <p>欢迎 <%= session.getAttribute("username") %>，您已成功登录。</p>
    <a href="login.jsp">安全退出</a>
</div>
</body>
</html>
