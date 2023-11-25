<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>导航栏</title>
    <link rel="stylesheet" href="../css/nav.css">
    <script src="../js/LinkManager.js"></script>
</head>
<body>

<div class="navbar">
    <a class="username">欢迎 <%= session.getAttribute("keyname") %>
    </a>
    <a href="../controller/book?activeLink=book"
       class="<%= session.getAttribute("activeLink") != null && session.getAttribute("activeLink").equals("controller/book") ? "active" : "" %>">图书信息</a>
    <a href="../controller/book_order?activeLink=book_order"
       class="<%= session.getAttribute("activeLink") != null && session.getAttribute("activeLink").equals("controller/book_order") ? "active" : "" %>">订单详情</a>
    <a href="../controller/comment?activeLink=comment"
       class="<%= session.getAttribute("activeLink") != null && session.getAttribute("activeLink").equals("controller/comment") ? "active" : "" %>">图书评价</a>
    <a href="../controller/order_detail?activeLink=order_detail"
       class="<%= session.getAttribute("activeLink") != null && session.getAttribute("activeLink").equals("controller/order_detail") ? "active" : "" %>">销售状态</a>
    <a href="../controller/user?activeLink=user"
       class="<%= session.getAttribute("activeLink") != null && session.getAttribute("activeLink").equals("controller/user") ? "active" : "" %>">用户管理</a>
    <a href="../../controller/login" class="logout">退出</a>
</div>


<script>
    var linkManager = new LinkManager();
    linkManager.init();
</script>
</body>
</html>
