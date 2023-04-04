package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
//import com.bean.UserBean;
//import com.dao.PassDao;
import com.dao.StudentDao;
import com.dao.UserDao;


public class ChangeMyPasswordServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String newPassword = request.getParameter("password");
		String otp = request.getParameter("otp");
		Cookie c[] = request.getCookies();
		int enrollmentNum=0;
		String email="";
		for (Cookie x : c) {
			if (x.getName().equals("enrollmentNum")) {
				enrollmentNum = Integer.valueOf(x.getValue());
			}if (x.getName().equals("email")) {
				email = x.getValue();
			}
		}
		
		StudentDao studentDao = new StudentDao();
		UserBean userBean = new UserBean();
		UserDao userDao = new UserDao();
		userBean = userDao.getMyData(enrollmentNum);
		//PassDao passDao = new PassDao();
		if(userBean.getRole()==1) {
			if(studentDao.otpVerification(otp, enrollmentNum)) {
				studentDao.setNewPassword(enrollmentNum,newPassword);
				RequestDispatcher rd = request.getRequestDispatcher("AdminDashboardServlet");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("ChangeMyDetails.jsp");
				rd.forward(request, response);
			}
		}
		else if(userBean.getRole()==2){
			if(studentDao.otpVerification(otp, enrollmentNum)) {
				studentDao.setNewPassword(enrollmentNum,newPassword);
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
				studentDao.setNewPassword(enrollmentNum,newPassword);
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
