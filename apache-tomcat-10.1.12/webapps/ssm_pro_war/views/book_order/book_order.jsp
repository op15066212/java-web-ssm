<%@ page import="service.list.book_orders" %>
<%@ page import="dao.bean.book_order" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单详情</title>
    <link rel="stylesheet" href="../../css/style-main.css">
</head>
<body>
<jsp:include page="../nav.jsp"/>
<div class="container">
    <h1>订单详情</h1>

    <div class="search-container">
        <form action="../../controller/book_order" method="post">
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
            <th>订单ID</th>
            <th>订单日期</th>
            <th>用户名称</th>
            <th>收货地址</th>
            <th>订单状态</th>
            <th>用户ID</th>
            <th>修改</th>
            <th>删除</th>
        </tr>
        </thead>
        <%-- 在这里插入后端代码查询数据库并将结果渲染到页面上 --%>

        <%-- 假设查询的结果存储在名为“orders”的ArrayList中 --%>
        <tbody>
        <%
            for (book_order order : book_orders.getOrders()) { %>
        <tr>
            <td><%= order.getOid() %>
            </td>
            <td><%= order.getDate() %>
            </td>
            <td><%= order.getOname() %>
            </td>
            <td><%= order.getAddress() %>
            </td>
            <td><%= order.getState() %>
            </td>
            <td><%= order.getUid() %>
            </td>
            <td>
                <form action="../../controller/book_order" method="post">
                    <input type="hidden" id="update" name="update" value="<%=order.getOid()%>">
                    <button type="submit">修改</button>
                </form>
            </td>
            <td>
                <form action="../../controller/book_order" method="post">
                    <input type="hidden" id="delete" name="delete" value="<%=order.getOid()%>">
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
