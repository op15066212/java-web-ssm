package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;

@WebServlet("/fileDelete")
public class FileDeleteServlet extends HttpServlet {

    private static final long serialVersionUID = -1533470342777261230L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String fileName = request.getParameter("fileName");
        if (fileName == null || fileName.isEmpty()) {
            response.sendRedirect("upload.jsp");
            return;
        }

        File file = new File("C:/temp/" + fileName);
        if (!file.exists() || !file.isFile()) {
            response.sendRedirect("upload.jsp");
            return;
        }

        if (!file.delete()) {
            response.sendRedirect("upload.jsp");
            return;
        }

        response.sendRedirect("upload.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
