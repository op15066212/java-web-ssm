<%@ page import="dao.bean.book" %>
<%@ page import="service.list.books" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书信息</title>
    <link rel="stylesheet" href="../../css/style-main.css">
</head>
<body>
<jsp:include page="../nav.jsp"/>
<div class="container">
    <h1>图书信息</h1>
    <div class="search-container">
        <form action="../../controller/book" method="post">
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
            <th>图书ID</th>
            <th>图书名称</th>
            <th>图书简介</th>
            <th>图书价格</th>
            <th>作者</th>
            <th>出版社</th>
            <th>出版日期</th>
            <th>图书类别</th>
            <th>预览图片</th>
            <th>图书库存</th>
            <th>修改</th>
            <th>删除</th>
        </tr>
        </thead>
        <%-- 在这里插入后端代码查询数据库并将结果渲染到页面上 --%>

        <%-- 假设查询的结果存储在名为“orders”的ArrayList中 --%>
        <tbody>
        <%
            for (book book : books.getList()) { %>
        <tr>
            <td><%= book.getBid() %>
            </td>
            <td><%= book.getBname() %>
            </td>
            <td><%= book.getDetail() %>
            </td>
            <td><%= book.getPrice() %>
            </td>
            <td><%= book.getWriter() %>
            </td>
            <td><%= book.getPrinter() %>
            </td>
            <td><%= book.getDate() %>
            </td>
            <td><%= book.getType() %>
            </td>
            <td><%= book.getImage() %>
            </td>
            <td><%= book.getStore() %>
            </td>
            <td>
                <form action="../../controller/bookupdate" method="post">
                    <input type="hidden" id="update" name="update" value="<%=book.getBid()%>">
                    <button type="submit">修改</button>
                </form>
            </td>
            <td>
                <form action="../../controller/book" method="post">
                    <input type="hidden" id="delete" name="delete" value="<%=book.getBid()%>">
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