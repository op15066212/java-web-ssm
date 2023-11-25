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
    <form action="../../controller/book_orderOutput" method="post">
        <div>
            <label for="oid">订单ID:</label>
            <input type="text" id="oid" name="oid" value="${book_orderUpdate.oid}" readonly>
        </div>
        <div>
            <label for="date">订单日期:</label>
            <input type="date" id="date" name="date" value="${book_orderUpdate.date}">
        </div>
        <div>
            <label for="oname">用户名称:</label>
            <input type="text" id="oname" name="oname" value="${book_orderUpdate.oname}">
        </div>
        <div>
            <label for="address">收货地址:</label>
            <textarea id="address" name="address" rows="2">${book_orderUpdate.address}</textarea>
        </div>
        <div>
            <label for="state">订单状态:</label>
            <input type="text" id="state" name="state" value="${book_orderUpdate.state}">
        </div>
        <div>
            <label for="uid">用户ID:</label>
            <input type="text" id="uid" name="uid" value="${book_orderUpdate.uid}">
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

<p>放弃修改？<a href="../controller/book_order">返回</a></p>

</body>
</html>

