package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;

@WebServlet("/ChangeStudentStatus")
public class ChangeStudentStatus extends HttpServlet{
	
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			Integer enrollmentNum = Integer.parseInt(request.getParameter("enrollmentNum"));
			Boolean currentStatus = Boolean.parseBoolean(request.getParameter("currentStatus"));
			System.out.println(enrollmentNum + " " + currentStatus);
			UserDao userDao = new UserDao();
			userDao.changeStudentStatus(enrollmentNum,currentStatus);

			//no data 
			response.sendRedirect("ListStudentServlet");
			
		}
	}
