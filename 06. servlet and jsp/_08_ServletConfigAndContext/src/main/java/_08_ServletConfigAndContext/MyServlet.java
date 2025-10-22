package _08_ServletConfigAndContext;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		PrintWriter out = res.getWriter();
		out.println("Hello ");

		ServletContext ctx = getServletContext();
		String name = ctx.getInitParameter("name");
		out.println("name: " + name);

		String phone = ctx.getInitParameter("phone");
		out.println("phone: " + phone);

		ServletConfig cg = getServletConfig();
		String innerName = cg.getInitParameter("innerName");
		out.println("innerName: " + innerName);
	}
}
