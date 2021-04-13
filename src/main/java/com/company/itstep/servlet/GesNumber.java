package com.company.itstep.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet
public class GesNumber extends HttpServlet {
    int first;
    int second;
    int res;

    @Override
    public void init(ServletConfig config) throws ServletException {
         first = 0;
         second = 100;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String answer = req.getParameter("answer");
        if (answer.equals(">")) {
            second = res;
        }else {
            first = res;
        }

        res = (int) (first + Math.random() * second);

        req.setAttribute("res", res);
    }
}
