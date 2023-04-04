package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.StudentDao;
import com.dao.UserDao;

/**
 * Servlet implementation class ChangeMyPhoneNumberServlet
 */
public class ChangeMyPhoneNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
		String otp = request.getParameter("otp");
		Cookie c[] = request.getCookies();
		int enrollmentNum=0;
		String email="";
		for (Cookie x : c) {
			if (x.getName().equals("enrollmentNum")) {
				enrollmentNum = Integer.valueOf(x.getValue());
			}
		}
		
		StudentDao studentDao = new StudentDao();
		UserBean userBean = new UserBean();
		UserDao userDao = new UserDao();
		userBean = userDao.getMyData(enrollmentNum);
		//PassDao passDao = new PassDao();
		if(userBean.getRole()==1) {
			if(studentDao.otpVerification(otp, enrollmentNum)) {
				studentDao.setNewPhoneNumber(enrollmentNum, phoneNumber);
				RequestDispatcher rd = request.getRequestDispatcher("AdminDashboardServlet");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("ChangeMyDetails.jsp");
				rd.forward(request, response);
			}
		}
		else if(userBean.getRole()==2){
			if(studentDao.otpVerification(otp, enrollmentNum)) {
				studentDao.setNewPhoneNumber(enrollmentNum,phoneNumber);
				//passDao.setNewDetailsForPass(enrollmentNum, newPassword);
				RequestDispatcher rd = request.getRequestDispatcher("HodDashboardServlet");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("ChangeMyDetails.jsp");
				rd.forward(request, response);
			}
		}
		else if(userBean.getRole()==4){
			if(studentDao.otpVerification(otp, enrollmentNum)) {
				studentDao.setNewPhoneNumber(enrollmentNum, phoneNumber);
				//passDao.setNewDetailsForPass(enrollmentNum, newPassword);
				RequestDispatcher rd = request.getRequestDispatcher("StudentDashboardServlet");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("ChangeMyDetails.jsp");
				rd.forward(request, response);
			}
		}
	}

}
