package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;


public class ShowMyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie c[] = request.getCookies();
		String email="";
		Integer enrollmentNum=0;
		for(Cookie x : c) {
			if (x.getName().equals("enrollmentNum")) {
				enrollmentNum = Integer.valueOf(x.getValue());
			}
		}
		UserDao userDao = new UserDao();
		UserBean userBean = userDao.getMyData(enrollmentNum);
		request.setAttribute("data", userBean);
		RequestDispatcher rd = request.getRequestDispatcher("ShowMyInfo.jsp");
		rd.forward(request, response);
	}

}
