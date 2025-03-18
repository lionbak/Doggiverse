package com.community.servlet;

import com.community.users.UserDAO;
import com.community.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String emailPrefix = request.getParameter("email_prefix");
        String emailDomain = request.getParameter("email_domain");
        String customEmailDomain = request.getParameter("custom_email_domain");
        String nickname = request.getParameter("nickname");
        String dogName = request.getParameter("dog_name");
        String address = request.getParameter("address");
        String address2 = request.getParameter("addressDetail");
        String phoneNumber1 = request.getParameter("phone_number_1");
        String phoneNumber2 = request.getParameter("phone_number_2");
        String phoneNumber3 = request.getParameter("phone_number_3");
        String birthdayStr = request.getParameter("birthday");

        String phoneNumber = phoneNumber1 + "-" + phoneNumber2 + "-" + phoneNumber3;
        String email;

        if (!username.matches("^(?=.*[a-z])(?=.*\\d)[a-z\\d]{4,16}$")) {
            request.setAttribute("errorMessage", "아이디 형식을 확인해주세요.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }
        if (userDAO.isUsernameExist(username)) {
            request.setAttribute("errorMessage", "이미 존재하는 아이디입니다.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

        if (userDAO.isNicknameExist(nickname)) {
            request.setAttribute("errorMessage", "이미 존재하는 닉네임입니다.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

        if ("custom".equals(emailDomain)) {
            email = emailPrefix + "@" + customEmailDomain;
        } else {
            email = emailPrefix + emailDomain;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        try {
            birthday = dateFormat.parse(birthdayStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (!phoneNumber2.matches("\\d{3,4}") || !phoneNumber3.matches("\\d{4}")) {
            request.setAttribute("errorMessage", "전화번호는 숫자만 입력해주세요.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }
        // Server-side validation
        String errorMessage = validateInput(username, password, email, nickname, dogName, address, phoneNumber, birthdayStr);
        if (errorMessage != null) {
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setNickname(nickname);
        user.setDogName(dogName);
        user.setAddress(address);
        user.setAddress2(address2);
        user.setPhoneNumber(phoneNumber);
        user.setBirthday(birthday);

        try {
            if (userDAO.registerUser(user)) {
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("errorMessage", "회원가입에 실패했습니다.");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "서버 에러가 발생했습니다.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
    }

    private String validateInput(String username, String password, String email, String nickname, String dogName, String address, String phoneNumber, String birthdayStr) {
        if (username == null || username.trim().isEmpty()) {
            return "아이디를 입력하세요.";
        }

        if (password == null || password.length() < 8 || password.length() > 16) {
            return "비밀번호를 확인해주세요.";
        }

        if (email == null || !email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            return "유효한 이메일 주소를 입력하세요.";
        }

        if (nickname == null || nickname.trim().isEmpty()) {
            return "닉네임을 입력하세요.";
        }

        if (dogName == null || dogName.trim().isEmpty()) {
            return "애완견 이름을 입력하세요.";
        }

        if (address == null || address.trim().isEmpty()) {
            return "주소를 입력하세요.";
        }

        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            return "전화번호를 입력하세요.";
        }

        if (birthdayStr == null || birthdayStr.trim().isEmpty()) {
            return "생년월일을 입력하세요.";
        }

        return null;
    }
}
