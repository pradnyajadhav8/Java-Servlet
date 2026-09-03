package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDaoImpl;
import com.model.Student;
import com.dao.StudentDao;

public class StudentAddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		double marks = Double.parseDouble(req.getParameter("marks"));
		String gender = req.getParameter("gender");

		Student student = new Student(id, name, marks, gender);

		StudentDao dao = new StudentDaoImpl();

		int res = dao.addStudent(student);

		if (res > 0)
			out.print("<h1> success!!!</h1>");
		else
			out.print("<h1> failed to add </h1>");
	}
}
