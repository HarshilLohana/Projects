package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.HodDao;
import com.dao.SecurityDao;
import com.dao.StudentDao;
import com.dao.UserDao;

public class SecurityDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie c[] = request.getCookies();
		int enrollmentNum=0;
		for (Cookie x : c) {
			if (x.getName().equals("enrollmentNum")) {
				enrollmentNum = Integer.valueOf(x.getValue());
			}
		}
		UserDao userDao = new UserDao();
		SecurityDao securityDao = new SecurityDao();
		UserBean userBean = userDao.getMyData(enrollmentNum);
		String name = userBean.getFirstName();
		int totalAcceptedRequest = securityDao.getAllRequestByStatus().size();
		
		request.setAttribute("totalAcceptedRequest", totalAcceptedRequest);
		request.setAttribute("firstName", name);
		 RequestDispatcher rd = request.getRequestDispatcher("SecurityDashboard.jsp");
		 rd.forward(request, response);
	}

}
