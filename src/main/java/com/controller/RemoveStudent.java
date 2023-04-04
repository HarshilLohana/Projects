package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;


public class RemoveStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer enrollmentNum = Integer.parseInt(request.getParameter("enrollmentNum"));
		UserDao userDao = new UserDao();
		userDao.removeUser(enrollmentNum);

		response.sendRedirect("ListStudentServlet");
		
	}

}
