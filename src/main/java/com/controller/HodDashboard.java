package com.controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bean.UserBean;

import com.dao.HodDao;
import com.dao.PassDao;
import com.dao.StudentDao;
import com.dao.UserDao;



public class HodDashboard extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HodDao hodDao = new HodDao();
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
		int totalPassRequest = hodDao.getAllRequest().size();
		int totalAcceptedRequest = hodDao.getAllRequestByStatus(1).size();
		int totalRejectedRequest = hodDao.getAllRequestByStatus(-1).size();
		int totalPendingRequest = hodDao.getAllRequestByStatus(0).size();
		
		request.setAttribute("totalPassRequest", totalPassRequest);
		request.setAttribute("totalAcceptedRequest", totalAcceptedRequest);
		request.setAttribute("totalRejectedRequest", totalRejectedRequest);
		request.setAttribute("totalPendingRequest", totalPendingRequest);
		request.setAttribute("firstName", name);
		 RequestDispatcher rd = request.getRequestDispatcher("HodDashboard.jsp");
		 rd.forward(request, response);
		
	}

}
