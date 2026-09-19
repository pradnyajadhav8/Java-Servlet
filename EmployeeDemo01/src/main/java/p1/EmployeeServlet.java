package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		double salary=Double.parseDouble(req.getParameter("salary"));
		
		out.print("<body>");
		
		out.print("<h1>");
		out.print(id+"<br>");
		out.print(name+"<br>");
		out.print(salary+"<br>");
		out.print("</h1>");
		
		out.print("</body>");
		
		
	}
}
