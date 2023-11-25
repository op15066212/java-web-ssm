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
<h1>添加</h1>
<!-- 新增容器 -->
<div class="container">
    <form action="../../controller/commentadd" method="post">
        <div>
            <label for="cid">评价ID:</label>
            <input type="text" id="cid" name="cid" value="${commentadd.cid}">
        </div>
        <div>
            <label for="bid">订单ID:</label>
            <input type="text" id="bid" name="bid" value="${commentadd.bid}">
        </div>
        <div>
            <label for="uname">用户名称:</label>
            <input type="text" id="uname" name="uname" value="${commentadd.uname}">
        </div>
        <div>
            <label for="date">评价时间:</label>
            <input type="datetime-local" id="date" name="date" value="${commentadd.date}">
        </div>
        <div>
            <label for="content">评价内容:</label>
            <textarea id="content" name="content" rows="2">${commentadd.content}</textarea>
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


<p>放弃添加？<a href="../controller/comment">返回</a></p>

</body>
</html>
