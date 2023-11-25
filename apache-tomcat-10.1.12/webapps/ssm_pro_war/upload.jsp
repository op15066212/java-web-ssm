<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.io.File" %>
<!DOCTYPE html>
<html>
<head>
    <title>文件上传和下载</title>
    <link rel="stylesheet" href="css/upload.css">
</head>
<body>
<h2>文件上传和下载</h2>
<form action="fileUpload" method="post" enctype="multipart/form-data">
    <input type="file" name="file" multiple>
    <br>
    <input type="submit" value="上传">
</form>
<table>
    <tr>
        <th>文件名</th>
        <th>大小</th>
        <th>上传时间</th>
        <th>操作</th>
    </tr>
    <%
        File dir = new File("C:/temp");
        File[] files = dir.listFiles();
        for (File file : files) {
    %>
    <tr>
        <td><a href="fileDownload?fileName=<%=file.getName()%>" class="download-link"><%=file.getName()%>
        </a></td>
        <td><%=file.length() / 1024 / 1024%>.<%=file.length() / 1024%>MB</td>
        <td><%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(file.lastModified()))%>
        </td>
        <td>
            <a href="fileDownload?fileName=<%=file.getName()%>" class="download-link">下载</a>
            <a href="fileDelete?fileName=<%=file.getName()%>" class="delete-link">删除</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
