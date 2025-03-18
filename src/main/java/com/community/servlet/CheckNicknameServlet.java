package com.community.servlet;

import com.community.users.UserDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkNickname")
public class CheckNicknameServlet extends HttpServlet {
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        String nickname = request.getParameter("nickname");
        boolean isExist = userDAO.isNicknameExist(nickname);
        response.getWriter().write(String.valueOf(isExist));
    }
}
