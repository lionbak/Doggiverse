package com.community.servlet;

import com.community.users.UserDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkUsername")
public class CheckUsernameServlet extends HttpServlet {
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        String username = request.getParameter("username");
        boolean isExist = userDAO.isUsernameExist(username);
        response.getWriter().write(String.valueOf(isExist));
    }
}