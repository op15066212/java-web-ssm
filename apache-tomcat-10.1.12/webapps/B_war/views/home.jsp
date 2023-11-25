<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录成功</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            font-family: Arial, Helvetica, sans-serif;
        }

        .container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 2px 6px rgba(0, 0, 0, .1);
            padding: 30px;
            text-align: center;
        }

        h3 {
            margin: 20px 0 0;
            font-size: 24px;
            font-weight: bold;
            color: #333;
        }

        p {
            margin: 10px 0;
            font-size: 18px;
            color: #666;
        }

        a {
            display: inline-block;
            background-color: #2196F3;
            color: #fff;
            font-size: 18px;
            font-weight: bold;
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            transition: all .3s ease-in-out;
        }

        a:hover {
            background-color: #1E88E5;
            transform: scale(1.05);
        }
    </style>
</head>
<body>
<div class="container">
    <h3>登录成功！</h3>
    <p>欢迎 <%= session.getAttribute("username") %>，您已成功登录。</p>
    <a href="logout.jsp">安全退出</a>
</div>
</body>
</html>
