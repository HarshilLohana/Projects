package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.HodDao;



public class ChangePassStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int passId = Integer.parseInt(request.getParameter("passId"));
		int currentStatus = Integer.parseInt(request.getParameter("currentStatus"));
		System.out.println("Change Pass Status = " + passId);
		HodDao hodDao = new HodDao();
		hodDao.changePassStatus(passId,currentStatus);
		//no data 
		response.sendRedirect("ViewHodPendingRequest");
	}

}
