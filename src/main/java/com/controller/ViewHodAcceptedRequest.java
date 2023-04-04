package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.PassBean;
import com.dao.HodDao;



public class ViewHodAcceptedRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
			HodDao hodDao = new HodDao();
			ArrayList<PassBean> passBean = hodDao.getAllRequestByStatus(1);
			request.setAttribute("acceptedRequest", passBean);
			request.getRequestDispatcher("ViewHodAcceptedRequest.jsp").forward(request, response);
			
		}
	}
