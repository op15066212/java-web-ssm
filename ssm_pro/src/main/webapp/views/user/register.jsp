<%@ page import="static service.errors.Attribute.getRegisterError" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" href="../../css/login-register.css">
</head>
<body>
<h1>注册</h1>
<!-- 新增容器 -->
<div class="container">
    <form action="../../controller/register" method="post">
        <div>
            <label for="uname">用户名:</label>
            <input type="text" id="uname" name="uname" value="${register.uname}">
        </div>
        <div>
            <label for="password">密码:</label>
            <input type="password" id="password" name="password" value="${register.password}">
        </div>
        <div style="text-align: center;">
            <input type="submit" value="注册">
        </div>
    </form>
</div>

<!-- 新增 DIV，用于显示错误信息 -->
<% String error = getRegisterError(request);
    if (!error.isEmpty()) { %>
<div id="errorMsg"><%= error %>
</div>
<% } %>

<p>已经有账号？<a href="../../controller/login">登录</a></p>
</body>
</html>
