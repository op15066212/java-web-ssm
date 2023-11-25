<%@ page import="static service.errors.Attribute.getAddError" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="../../css/add-update.css">
</head>
<body>
<h1>修改</h1>
<!-- 新增容器 -->
<div class="container">
    <form action="../../controller/userOutput" method="post">
        <div>
            <label for="uid">用户ID:</label>
            <input type="text" id="uid" name="uid" value="${userUpdate.uid}" readonly>
        </div>
        <div>
            <label for="uname">用户名:</label>
            <input type="text" id="uname" name="uname" value="${userUpdate.uname}" readonly>
        </div>
        <div>
            <label for="password">密码:</label>
            <input type="text" id="password" name="password" value="${userUpdate.password}">
        </div>
        <div>
            <label for="gender">性别:</label>
            <input type="text" id="gender" name="gender" value="${userUpdate.gender}">
        </div>
        <div>
            <label for="phone">电话:</label>
            <input type="text" id="phone" name="phone" value="${userUpdate.phone}">
        </div>
        <div>
            <label for="email">邮箱:</label>
            <input type="text" id="email" name="email" value="${userUpdate.email}">
        </div>
        <div>
            <label for="address">家庭住址:</label>
            <textarea id="address" name="address" rows="2">${userUpdate.address}</textarea>
        </div>
        <div>
            <input type="submit" value="提交">
        </div>
    </form>
</div>

<!-- 新增 DIV，用于显示错误信息 -->
<% String error = getAddError(request);
    if (!error.isEmpty()) { %>
<div id="errorMsg"><%= error %>
</div>
<% } %>

<p>放弃修改？<a href="../controller/user">返回</a></p>

</body>
</html>
