package _16_FilterServlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addAlien")
public class MyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		int aid = Integer.parseInt(req.getParameter("aid"));
		String name = req.getParameter("aname");

		PrintWriter out = res.getWriter();
		out.println("Welcome " + name);
	}
}
