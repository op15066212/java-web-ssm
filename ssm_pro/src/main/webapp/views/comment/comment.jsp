<%@ page import="dao.bean.comment" %>
<%@ page import="service.list.comments" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书评价</title>
    <link rel="stylesheet" href="../../css/style-main.css">
</head>
<body>
<jsp:include page="../nav.jsp"/>
<div class="container">
    <h1>图书评价</h1>
    <div class="search-container">
        <form action="../../controller/comment" method="post">
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
            <th>评价ID</th>
            <th>订单ID</th>
            <th>用户名称</th>
            <th>评价时间</th>
            <th>评价内容</th>
            <th>修改</th>
            <th>删除</th>
        </tr>
        </thead>
        <%-- 在这里插入后端代码查询数据库并将结果渲染到页面上 --%>

        <%-- 假设查询的结果存储在名为“orders”的ArrayList中 --%>
        <tbody>
        <%
            for (comment order : comments.getList()) { %>
        <tr>
            <td><%= order.getCid() %>
            </td>
            <td><%= order.getBid() %>
            </td>
            <td><%= order.getUname() %>
            </td>
            <td><%= order.getDate() %>
            </td>
            <td><%= order.getContent() %>
            </td>
            <td>
                <form action="../../controller/commentupdate" method="post">
                    <input type="hidden" id="update" name="update" value="<%=order.getCid()%>">
                    <button type="submit">修改</button>
                </form>
            </td>
            <td>
                <form action="../../controller/comment" method="post">
                    <input type="hidden" id="delete" name="delete" value="<%=order.getCid()%>">
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
