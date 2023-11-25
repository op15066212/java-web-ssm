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
    <form action="../../controller/bookOutput" method="post">
        <div>
            <label for="bid">
                图书ID:
            </label>
            <input type="text" id="bid" name="bid" value="${bookUpdate.bid}" readonly>
        </div>
        <div>
            <label for="bname">图书名称:</label>
            <input type="text" id="bname" name="bname" value="${bookUpdate.bname}">
        </div>
        <div>
            <label for="detail">图书简介:</label>
            <textarea id="detail" name="detail" rows="2">${bookUpdate.detail}</textarea>
        </div>
        <div>
            <label for="price">图书价格:</label>
            <input type="text" id="price" name="price" value="${bookUpdate.price}">
        </div>
        <div>
            <label for="writer">作者:</label>
            <input type="text" id="writer" name="writer" value="${bookUpdate.writer}">
        </div>
        <div>
            <label for="printer">出版社:</label>
            <input type="text" id="printer" name="printer" value="${bookUpdate.printer}">
        </div>
        <div>
            <label for="date">出版日期:</label>
            <input type="date" id="date" name="date" value="${bookUpdate.date}">
        </div>
        <div>
            <label for="type">图书类别:</label>
            <input type="text" id="type" name="type" value="${bookUpdate.type}">
        </div>
        <div>
            <label for="store">图书库存:</label>
            <input type="text" id="store" name="store" value="${bookUpdate.store}">
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

<p>放弃修改？<a href="../controller/book">返回</a></p>

</body>
</html>
