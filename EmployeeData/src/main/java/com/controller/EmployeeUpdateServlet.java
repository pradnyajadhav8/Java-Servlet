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
import com.model.Employee;


@WebServlet("/update")
public class EmployeeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EmployeeUpdateServlet() {
        super();
    }

    private EmployeeDAO dao;
    
    @Override
    public void init() throws ServletException {
    	dao=new EmployeeDAOImpl();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		double salary=Double.parseDouble(request.getParameter("salary"));
		
		Employee employee=new Employee(id,name,salary);
		
		int row = dao.updateEmployee(employee);
		
		if(row>0) {
			out.print("<h1> Successfully Updated </h1>");
			request.getRequestDispatcher("/read").forward(request, response);
		}
		else
			out.print("<h1> Failed to update..!</h1>");
		
		
	}

}
