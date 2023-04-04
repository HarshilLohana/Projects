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
import com.dao.StudentDao;

@WebServlet("/ViewRejectedRequest")
public class ViewRejectedRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie c[] = request.getCookies();
		int enrollmentNum=0;
		for (Cookie x : c) {
			if (x.getName().equals("enrollmentNum")) {
				enrollmentNum = Integer.valueOf(x.getValue());
			}
		}
		StudentDao studentDao = new StudentDao();
		ArrayList<PassBean> passBean = studentDao.getAllMyRequestByStatus(enrollmentNum, -1);
		request.setAttribute("rejectedRequest", passBean);
		request.getRequestDispatcher("ViewRejectedRequest.jsp").forward(request, response);
		
	}

}
