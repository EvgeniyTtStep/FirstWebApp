package com.company.itstep.servlet;

import com.company.itstep.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("user.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String check1 = req.getParameter("check");
        boolean check = check1 != null;


        System.out.println("req.getParameter(\"check\") = " + req.getParameter("check"));
        int age = Integer.parseInt(req.getParameter("age"));

        UUID uuid = UUID.randomUUID();

        User user = new User(name, lastName, email, age, check);
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        req.setAttribute("user", user);

        HttpSession session = req.getSession();//создание обьекта сессии
        //session.setAttribute("data", "some session from servlet");
        session.setAttribute("userSession", user);
        System.out.println("Session id = " + session.getId());
        System.out.println("session.getCreationTime() = " + session.getCreationTime());
        session.setMaxInactiveInterval(15);



        Cookie cookie = new Cookie("cookieName", "cookieValue");
        System.out.println("cookie value = " + cookie.getValue());
        cookie.setMaxAge(10);
        //cookie.setPath("/home");
        resp.addCookie(cookie);


        req.getRequestDispatcher("user.jsp").forward(req,resp);
    }
}
