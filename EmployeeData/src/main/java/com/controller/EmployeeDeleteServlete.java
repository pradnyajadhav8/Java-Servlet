package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;


@WebServlet("/delete")
public class EmployeeDeleteServlete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public EmployeeDeleteServlete() {
        super();
        
    }
    
    private EmployeeDAO dao;
	
	public void init() throws ServletException {
		dao = new EmployeeDAOImpl();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		int row=dao.deleteEmployee(id);
		
		if(row>0) {
			out.println("<h1> Sucessfully Deleted..!</h1>");
			req.getRequestDispatcher("/read").forward(req, resp);
		}
		else
			out.println("<h1> Failed to deletd..! </h1>");
		
	}

}
