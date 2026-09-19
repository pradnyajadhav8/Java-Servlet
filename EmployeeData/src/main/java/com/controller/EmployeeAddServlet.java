package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.model.Employee;

public class EmployeeAddServlet extends HttpServlet{

	private EmployeeDAO dao;
	
	public void init() throws ServletException {
		dao = new EmployeeDAOImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		PrintWriter out=resp.getWriter();
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		double salary=Double.parseDouble(req.getParameter("salary"));
		
		Employee employee=new Employee(id,name,salary);
		
		int row=dao.addEmployee(employee);
		
		if(row>0) {
			out.println("<h1> suceess to add </h1>");
			req.getRequestDispatcher("/read").forward(req, resp);
		}
		else
			out.println("<h1> failed to add </h1>");
		
		
	}
}
