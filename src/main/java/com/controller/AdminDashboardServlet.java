package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.AdminDao;
import com.dao.StudentDao;
import com.dao.UserDao;


public class AdminDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDao adminDao = new AdminDao();
		UserDao userDao = new UserDao();
		Cookie c[] = request.getCookies();
		int enrollmentNum=0;
		for (Cookie x : c) {
			if (x.getName().equals("enrollmentNum")) {
				enrollmentNum = Integer.valueOf(x.getValue());
			}
		}
		UserBean userBean = userDao.getMyData(enrollmentNum);
		String name = userBean.getFirstName();
		int totalUsers = adminDao.getAllUsers().size();
		int totalStudents = adminDao.getAllUsersByStatus(4).size();
		int totalHods = adminDao.getAllUsersByStatus(2).size();
		int totalSecurities = adminDao.getAllUsersByStatus(3).size();
		
		request.setAttribute("totalUsers", totalUsers);
		request.setAttribute("totalStudents", totalStudents);
		request.setAttribute("totalHods", totalHods);
		request.setAttribute("totalSecurities", totalSecurities);
		request.setAttribute("firstName", name);
		 RequestDispatcher rd = request.getRequestDispatcher("AdminDashboard.jsp");
		 rd.forward(request, response);
	}

}
