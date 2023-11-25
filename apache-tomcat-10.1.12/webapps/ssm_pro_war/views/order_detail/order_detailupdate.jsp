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
    <form action="../../controller/order_detailupdate" method="post">
        <div>
            <label for="id">评价详情ID:</label>
            <input type="text" id="id" name="id" value="${sessionScope.id}" readonly>
        </div>
        <div>
            <label for="order_id">订单ID:</label>
            <input type="text" id="order_id" name="order_id" value="${sessionScope.order_id}">
        </div>
        <div>
            <label for="book_id">图书ID:</label>
            <input type="text" id="book_id" name="book_id" value="${sessionScope.book_id}">
        </div>
        <div>
            <label for="book_num">图书数量:</label>
            <input type="text" id="book_num" name="book_num" value="${sessionScope.book_num}">
        </div>
        <div>
            <label for="status">评价状态:</label>
            <input type="text" id="status" name="status" value="${sessionScope.status}">
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

<%
    session.setAttribute("searchInput", null);
    session.setAttribute("id", null);
    session.setAttribute("order_id", null);
    session.setAttribute("book_id", null);
    session.setAttribute("book_num", null);
    session.setAttribute("status", null);
%>

<p>放弃修改？<a href="../controller/order_detail">返回</a></p>

</body>
</html>
