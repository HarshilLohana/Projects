package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.PassBean;
import com.bean.UserBean;
import com.dao.PassDao;
import com.dao.UserDao;

@WebServlet("/GetMyRequestServlet")
public class GetMyRequestServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie c[] = request.getCookies();
		int enrollmentNum=0;
		for (Cookie x : c) {
			if (x.getName().equals("enrollmentNum")) {
				enrollmentNum = Integer.valueOf(x.getValue());
			}
		}
		PassDao passDao = new PassDao();
		ArrayList<PassBean> pastRequest = passDao.getMyList(enrollmentNum);
		
		request.setAttribute("pastRequest", pastRequest);
		request.getRequestDispatcher("getMyRequest.jsp").forward(request, response);
	}
}
