package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.constants.Role;
import com.dao.UserDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserDao userDao = new UserDao();
		UserBean user = userDao.authenticate(email, password);
		RequestDispatcher rd = null;
		if(user==null) {
			System.out.println("Invalid!!");
			request.setAttribute("error", "Invalid Email or Password!!");
			rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}else {
			System.out.println(user.getRole() + " " + Role.STUDENT.role);
			if (user.getRole() == Role.STUDENT.role) {
				Cookie c = new Cookie("enrollmentNum", user.getEnrollmentNum()+"");
				response.addCookie(c);
				Cookie c1 = new Cookie("email", user.getEmail()+"");
				response.addCookie(c1);
				response.sendRedirect("StudentDashboardServlet");
			} else if (user.getRole() == Role.ADMIN.role) {
				Cookie c = new Cookie("enrollmentNum", user.getEnrollmentNum()+"");
				response.addCookie(c);
				Cookie c1 = new Cookie("email", user.getEmail()+"");
				response.addCookie(c1);
				response.sendRedirect("AdminDashboardServlet");
			} else if (user.getRole() == Role.HOD.role) {
				Cookie c = new Cookie("enrollmentNum", user.getEnrollmentNum()+"");
				response.addCookie(c);
				Cookie c1 = new Cookie("email", user.getEmail()+"");
				response.addCookie(c1);
				response.sendRedirect("HodDashboard");
			} else if (user.getRole() == Role.SECURITY.role) {
				Cookie c = new Cookie("enrollmentNum", user.getEnrollmentNum()+"");
				response.addCookie(c);
				Cookie c1 = new Cookie("email", user.getEmail()+"");
				response.addCookie(c1);
				response.sendRedirect("SecurityDashboardServlet");
		}
	}
	}
}
