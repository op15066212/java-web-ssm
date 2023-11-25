package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.Collection;

@WebServlet("/fileUpload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 100, // 100MB
        maxFileSize = -1, // 不限制文件大小
        maxRequestSize = -1) // 不限制请求大小
public class FileUploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // 获取上传的文件集合
        Collection<Part> fileParts = request.getParts();
        if (fileParts == null || fileParts.isEmpty()) {
            response.sendRedirect("upload.jsp");
            return;
        }

        for (Part filePart : fileParts) {
            String fileName = filePart.getSubmittedFileName();
            if (fileName == null || fileName.isEmpty()) {
                continue;
            }
            filePart.write("C:/temp/" + fileName);
        }

        // 重定向回上传页面
        response.sendRedirect("upload.jsp");
    }
}
