package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.dao.StudentFactory;


@WebServlet("/read")
public class StudentReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDAO studentDAO;

	@Override
	public void init() throws ServletException {
		
		studentDAO= StudentFactory.getStudentFactory();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//read all data here Display 
		
		
	}

	
}
