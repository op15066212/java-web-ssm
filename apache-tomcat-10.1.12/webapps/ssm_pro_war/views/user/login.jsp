<%@ page import="static service.errors.Attribute.getLoginError" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="../../css/login-register.css">
</head>
<body>
<h1>登录</h1>
<!-- 新增容器 -->
<div class="container">
    <form action="../../controller/login" method="post">
        <div>
            <label for="username">用户名:</label>
            <input type="text" id="username" name="username" value="${sessionScope.username}">
        </div>
        <div>
            <label for="password">密码:</label>
            <input type="password" id="password" name="password" value="${sessionScope.password}">
        </div>
        <div>
            <input type="submit" value="登录">
        </div>
    </form>
</div>

<!-- 新增 DIV，用于显示错误信息 -->
<% String error = getLoginError(request);
    if (!error.isEmpty()) { %>
<div id="errorMsg"><%= error %>
</div>
<% } %>


<%
    session.setAttribute("username", null);
    session.setAttribute("password", null);
%>

<p>还没有账号？<a href="../../controller/register">注册</a></p>

</body>
</html>
