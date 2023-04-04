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
import com.service.EmailService;


public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String email = request.getParameter("email");
	   System.out.println(email);
	   UserDao userDao = new UserDao();
	   String newEmail="";
	   Cookie c[] = request.getCookies();
	   Integer enrollmentNum=0;
	for(Cookie x : c) {
		   if (x.getName().equals("enrollmentNum")) {
				enrollmentNum = Integer.valueOf(x.getValue());
			}
	   }
	   if(email.equals(newEmail)) {
		   UserBean userBean = userDao.getMyData(enrollmentNum);
		   if(userBean == null) {
			   response.sendRedirect("EmailForChangeDetail.jsp");
		   }else {
			   String characters="AB90CDEF12GHIJKLMNOPQRSTUVWXY45Zhijklmn34opqrst890uvw67xyz125abcdefg";
			   String otp="";
			   int index=0;
			   for(int i=0;i<=8;i++) {
				   index = (int)(Math.random()*10);
				   otp = otp + characters.charAt(index);
			   }
			   userBean.setOtp(otp);
			   userDao.insertMyOtp(userBean);
			   
			   EmailService emailService = new EmailService();
				emailService.sendOtpForForgetPassword(email, otp);
				RequestDispatcher rd = request.getRequestDispatcher("ChangeMyDetails.jsp");
				rd.forward(request, response);
		   }
	   }else {
		   response.sendRedirect("EmailForChangeDetail.jsp");
	   }
	  
   }

}
