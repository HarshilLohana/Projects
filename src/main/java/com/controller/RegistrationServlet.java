package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.constants.Role;
import com.dao.UserDao;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int enrollmentNum = Integer.parseInt(request.getParameter("enroll"));
		
		
		UserBean userbean= new UserBean();
		userbean.setFirstName(firstName);
		userbean.setEmail(email);
		userbean.setPassword(password);
		userbean.setEnrollmentNum(enrollmentNum);;
		userbean.setRole(Role.STUDENT.role);
		userbean.setApprove(false);
		new UserDao().addUser(userbean);
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		rd.forward(request,response);
	}
}
