package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.constants.Role;
import com.dao.UserDao;


public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		int enrollmentNum = Integer.parseInt(request.getParameter("enroll"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserBean userbean= new UserBean();
		userbean.setFirstName(firstName);
		userbean.setEnrollmentNum(enrollmentNum);
		userbean.setEmail(email);
		userbean.setPassword(password);
		userbean.setRole(Role.STUDENT.role);
		userbean.setApprove(true);
		new UserDao().addUser(userbean);
		response.sendRedirect("AdminDashboardServlet");
	}

}
