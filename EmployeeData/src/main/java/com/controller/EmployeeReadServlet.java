package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.model.Employee;


@WebServlet("/read")
public class EmployeeReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public EmployeeReadServlet() {
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
		
		List<Employee>list=dao.allEmployee();
		
		out.print("<body>");
		
		System.out.println(list);
		out.print("<table style='width:100%'> ");
		out.print("<tr>");
		out.print("<th>"+"Id"+"</th>");
		out.print("<th>"+"Name"+"</th>");
		out.print("<th>"+"Salary"+"</th>");
		
		out.print("</tr>");
		
		for(Employee emp:list) {
			out.print("<tr>");
			out.print("<td>"+emp.getId()+"</td>");
			out.print("<td>"+emp.getName()+"</td>");
			out.print("<td>"+emp.getSalary()+"</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("</body>");
		
	}

}
