<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="css/login-register.css">
</head>
<body>
<h1>登录</h1>
<!-- 新增容器 -->
<div class="container">
    <form action="LoginServlet" method="post">
        <div>
            <label for="username">用户名:</label>
            <input type="text" id="username" name="username">
        </div>
        <div>
            <label for="password">密码:</label>
            <input type="password" id="password" name="password">
        </div>
        <div>
            <input type="submit" value="登录">
        </div>
    </form>
</div>

<!-- 新增 DIV，用于显示错误信息 -->
<% if (request.getParameter("error") != null) { %>
<% if (request.getParameter("error").equals("0")) { %>
<div id="errorMsg">账号不存在</div>
<% } else if (request.getParameter("error").equals("1")) { %>
<div id="errorMsg">账号或密码错误</div>
<% } %>
<% } %>

<p>还没有账号？<a href="register.jsp">注册</a></p>
</body>
</html>
