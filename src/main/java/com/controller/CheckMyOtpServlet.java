package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.StudentDao;

@WebServlet("/CheckMyOtpServlet")
public class CheckMyOtpServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie c[] = request.getCookies();
		int enrollmentNum=0;
		for (Cookie x : c) {
			if (x.getName().equals("enrollmentNum")) {
				enrollmentNum = Integer.valueOf(x.getValue());
			}
		}
		String otp = request.getParameter("otp");
		String password = request.getParameter("password");
		StudentDao studentDao = new StudentDao();
		if(studentDao.otpVerification(otp, enrollmentNum)) {
			studentDao.setNewPassword(password, enrollmentNum);
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("ChangeMyDetails.jsp");
			rd.forward(request, response);
		}
	}
}
