package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;


public class ListAllStudentServletHod extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userDao = new UserDao();
		ArrayList<UserBean> students = userDao.getAllStudents();
		request.setAttribute("students", students);
		request.getRequestDispatcher("ListStudentsForHod.jsp").forward(request, response);
	}

}
