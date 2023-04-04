package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.PassBean;

import com.dao.HodDao;

public class AllRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HodDao hodDao = new HodDao();
		ArrayList<PassBean> pastRequest = hodDao.getAllRequest();
		request.setAttribute("pastRequest", pastRequest);
		request.getRequestDispatcher("ViewHodAllRequest.jsp").forward(request, response);
	}

}
