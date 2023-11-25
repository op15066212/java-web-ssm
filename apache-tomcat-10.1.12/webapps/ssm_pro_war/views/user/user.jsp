<%@ page import="dao.bean.user" %>
<%@ page import="service.list.users" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <link rel="stylesheet" href="../../css/style-main.css">
</head>
<body>
<jsp:include page="../nav.jsp"/>
<div class="container">
    <h1>用户管理</h1>
    <div class="search-container">
        <form action="../../controller/user" method="post">
            <label for="search">
                <input type="text"
                       placeholder="请输入关键字"
                       id="search-input"
                       name="search-input"
                       class="search-box"
                       value="${sessionScope.searchInput}">
            </label>
            <button type="submit" id="search" name="search" class="btn">搜索
            </button>
            <button type="submit" id="clear" name="clear" class="btn">清空
            </button>
            <button type="submit" id="add" name="add" class="btn-add-book">添加
            </button>
        </form>
    </div>

    <table>
        <thead>
        <tr>
            <th>用户ID</th>
            <th>用户名</th>
            <th>密码</th>
            <th>性别</th>
            <th>电话</th>
            <th>邮箱</th>
            <th>家庭住址</th>
            <th>修改</th>
            <th>删除</th>
        </tr>
        </thead>
        <%-- 在这里插入后端代码查询数据库并将结果渲染到页面上 --%>

        <%-- 假设查询的结果存储在名为“orders”的ArrayList中 --%>
        <tbody>
        <%
            for (user order : users.getList()) { %>
        <tr>
            <td><%= order.getUid() %>
            </td>
            <td><%= order.getUname() %>
            </td>
            <td><%= order.getPassword() %>
            </td>
            <td><%= order.getGender() %>
            </td>
            <td><%= order.getPhone() %>
            </td>
            <td><%= order.getEmail() %>
            </td>
            <td><%= order.getAddress() %>
            </td>
            <td>
                <form action="../../controller/user" method="post">
                    <input type="hidden" id="update" name="update" value="<%=order.getUid()%>">
                    <button type="submit">修改</button>
                </form>
            </td>
            <td>
                <form action="../../controller/user" method="post">
                    <input type="hidden" id="delete" name="delete" value="<%=order.getUid()%>">
                    <button type="submit">删除</button>
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>
