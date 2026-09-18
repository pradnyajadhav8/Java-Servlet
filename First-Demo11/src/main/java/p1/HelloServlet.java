package p1;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements Servlet {

	static {
		System.out.println("Static Block HelloServlet");
	}
	
	public HelloServlet() {
		System.out.println("HelloServlet Constructor ");
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet Destroy Called..!");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet Init Called ");	
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Servlet  service method called");
	}

}
