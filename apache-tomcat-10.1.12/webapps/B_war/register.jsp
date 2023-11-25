<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <style>
        body {
            text-align: center;
        }

        /* 新增样式 */
        .container {
            display: flex;
            justify-content: center;
        }

        form {
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 20px;
            box-shadow: 0 2px 6px rgba(0, 0, 0, .1);
            background-color: #fff;
            text-align: left;
        }

        label {
            display: inline-block;
            width: 100px;
            text-align: right;
            margin-right: 10px;
        }

        input[type="text"], input[type="password"] {
            width: 200px;
            padding: 5px 10px;
            margin-bottom: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            display: block;
            margin: 10px auto;
            width: 150px;
            height: 40px;
            font-size: 18px;
            font-weight: bold;
            color: #fff;
            background-color: #2196F3;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: all .3s ease-in-out;
        }

        input[type="submit"]:hover {
            background-color: #1E88E5;
            transform: scale(1.05);
        }

        p {
            margin-top: 20px;
            font-size: 14px;
        }

        /* 新增样式 */
        #errorMsg {
            margin: 10px auto;
            width: 300px;
            padding: 10px;
            background-color: #FFEBEE;
            color: #C62828;
            font-size: 14px;
            text-align: center;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<h1>注册</h1>
<!-- 新增容器 -->
<div class="container">
    <form action="RegisterServlet" method="post">
        <div>
            <label for="username">用户名:</label>
            <input type="text" id="username" name="username">
        </div>
        <div>
            <label for="password">密码:</label>
            <input type="password" id="password" name="password">
        </div>
        <div style="text-align: center;">
            <input type="submit" value="注册">
        </div>
    </form>
</div>

<!-- 新增 DIV，用于显示错误信息 -->
<% if (request.getParameter("error") != null) { %>
<% if (request.getParameter("error").equals("0")) { %>
<div id="errorMsg">账号已经存在</div>
<% } %>
<% } %>

<p>已经有账号？<a href="login.jsp">登录</a></p>
</body>
</html>
