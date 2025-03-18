package com.community.users;
import com.community.model.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doPost(request, response);
		//로그아웃
//		HttpSession session = request.getSession();
//		//세션 종료
//		session.invalidate();
//		//세션 유효타임
//		session.setMaxInactiveInterval(200);
//		response.sendRedirect("index.jsp");
  }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String pagecode = request.getParameter("pagecode");
		UserDAO dao = new UserDAO();

		if(pagecode.equals("P002")) {
			String userid = request.getParameter("username");
			String password = request.getParameter("password");

			UserVO loginCheck = dao.userLogin(userid, password);


			if(loginCheck != null) {

				HttpSession session = request.getSession();
				session.setAttribute("username", loginCheck.getUsername());
				session.setAttribute("email", loginCheck.getEmail());  // Assuming these methods exist
				session.setAttribute("nickname", loginCheck.getNickname());
				session.setAttribute("dogName", loginCheck.getDog_name());
				session.setAttribute("address", loginCheck.getAddress());
				session.setAttribute("address2", loginCheck.getAddress2());
				session.setAttribute("phoneNumber", loginCheck.getPhoneNumber());
				response.sendRedirect("index.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("errorMessage", "아이디 또는 비밀번호가 잘못되었습니다.");
				response.sendRedirect("login.jsp");
			}
		}else if (pagecode.equals("updateInfo")) {

			handleUpdateInfo(request, response, dao);
		}else if (pagecode.equals("logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("login.jsp");
		}else if (pagecode.equals("deleteAccount")) {
			handleDeleteAccount(request, response, dao);
		}else if (pagecode.equals("changePassword")) {
			handleChangePassword(request, response, dao);
		}else {
			response.sendRedirect("viewAccount.jsp");
			return;
		}
		doGet(request,response);
	}

	private void handleUpdateInfo(HttpServletRequest request, HttpServletResponse response, UserDAO dao) throws IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String nickname = request.getParameter("nickname");
		String dogName = request.getParameter("dogName");
		String address = request.getParameter("address");
		String address2 = request.getParameter("address2");
		String phoneNumber1 = request.getParameter("phone_number_1");
		String phoneNumber2 = request.getParameter("phone_number_2");
		String phoneNumber3 = request.getParameter("phone_number_3");
		String phoneNumber = phoneNumber1 + "-" + phoneNumber2 + "-" + phoneNumber3;

		boolean updateSuccessful = dao.updateUserInfo(username, nickname, dogName, address, address2, phoneNumber);

		if (updateSuccessful) {
			session.setAttribute("nickname", nickname);
			session.setAttribute("dogName", dogName);
			session.setAttribute("address", address);
			session.setAttribute("address2", address2);
			session.setAttribute("phoneNumber", phoneNumber);
			response.sendRedirect("viewAccount.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}
	}

	private void handleDeleteAccount(HttpServletRequest request, HttpServletResponse response, UserDAO dao) throws IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		boolean deleteSuccessful = dao.deleteUser(username);

		if (deleteSuccessful) {
			session.invalidate(); // Log the user out
			response.sendRedirect("accountDeleted.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}
	}

	private void handleChangePassword(HttpServletRequest request, HttpServletResponse response, UserDAO dao) throws IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String currentPassword = request.getParameter("currentPassword");
		String newPassword = request.getParameter("newPassword");

		boolean isCurrentPasswordValid = dao.verifyPassword(username, currentPassword);
		if (isCurrentPasswordValid) {
			if (currentPassword.equals(newPassword)) {
				response.getWriter().write("same_as_current_password");
			} else {
				boolean isPasswordUpdated = dao.updateUserPassword(username, newPassword);
				if (isPasswordUpdated) {
					response.getWriter().write("success");
				} else {
					response.getWriter().write("update_failed");
				}
			}
		} else {
			response.getWriter().write("invalid_current_password");
		}
	}


}
