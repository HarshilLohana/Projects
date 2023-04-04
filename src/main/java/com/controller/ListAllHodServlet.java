package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.AdminDao;


public class ListAllHodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDao adminDao = new AdminDao();
		ArrayList<UserBean> hods = adminDao.getAllUsersByStatus(2);
		request.setAttribute("hods", hods);
		request.getRequestDispatcher("ListHod.jsp").forward(request, response);
	}

}
