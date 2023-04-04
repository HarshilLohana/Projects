package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.PassBean;
import com.dao.HodDao;
import com.dao.SecurityDao;


public class ViewAllSecurityRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SecurityDao securityDao = new SecurityDao();
		ArrayList<PassBean> passBean = securityDao.getAllRequestByStatus();
		request.setAttribute("acceptedRequest", passBean);
		request.getRequestDispatcher("ViewAllSecurityRequest.jsp").forward(request, response);
	}

}
