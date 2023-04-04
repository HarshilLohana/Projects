package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HodDao;
import com.dao.SecurityDao;


public class VerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int passId = Integer.parseInt(request.getParameter("passId"));
		SecurityDao securityDao = new SecurityDao();
		securityDao.verifyRequest(passId);
		//no data 
		response.sendRedirect("ViewAllSecurityRequest");
	}

}
