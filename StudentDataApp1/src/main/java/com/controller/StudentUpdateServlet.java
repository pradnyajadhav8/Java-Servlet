package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.model.Student;

@WebServlet("/update")
public class StudentUpdateServlet extends HttpServlet{

	private StudentDao dao;

	public void init() throws ServletException {
		dao = new StudentDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		double marks = Double.parseDouble(req.getParameter("marks"));
		String gender = req.getParameter("gender");

		Student student = new Student(id, name, marks, gender);

		int res = dao.updatestudent(student);

		if (res > 0)
			out.print("<h1> success!!!</h1>");
		else
			out.print("<h1> failed to add </h1>");
		
	}
	
}
