package com.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.PassBean;
import com.bean.UserBean;
import com.dao.PassDao;
import com.dao.StudentDao;
import com.dao.UserDao;
import com.service.EmailService;

@WebServlet("/ApplyForPassServlet")
public class ApplyForPassServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Date d = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		String today = df.format(d);

		String reason = request.getParameter("reason");
		String outTime = request.getParameter("outtime");

		// validation

		// cookie get

		Cookie c[] = request.getCookies();
		int enrollmentNum=0;
		for (Cookie x : c) {
			if (x.getName().equals("enrollmentNum")) {
				enrollmentNum = Integer.valueOf(x.getValue());
			}
		}
		UserDao userDao = new UserDao();
		UserBean userBean = userDao.getMyData(enrollmentNum);
		PassBean pass = new PassBean();
		pass.setEnrollmentNum(enrollmentNum);
		pass.setReason(reason);
		pass.setPassDate(today);
		pass.setApprove(0);
		pass.setOutTime(outTime);
		EmailService emailService = new EmailService();
		emailService.sendMessageForApplyPass(enrollmentNum,userBean.getFirstName(),pass.getReason(),pass.getApprove());
		PassDao passDao = new PassDao();
		passDao.addPassRequest(pass);

		RequestDispatcher rd = request.getRequestDispatcher("StudentDashboardServlet");
		rd.forward(request, response);

	}
	}

