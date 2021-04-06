package com.company.itstep.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyServlet")
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        response.setContentType("text/html");
        printWriter.println("<h1>Mapping Shop</h1>");
        String first = request.getParameter("first");
        String second = request.getParameter("second");
        System.out.println(first + " " + second);

        printWriter.println("first = " + first+"<br>");
        printWriter.println("second = " + second + "<br>");


//        String str = "<h1>Mapping Shop</h1>";
//        response.getWriter().write(str);
    }
}
