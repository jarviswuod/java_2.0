package _06_HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SquareServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		HttpSession session = req.getSession();

		// session.removeAttribute("k");

		int k = (int) session.getAttribute("k");
		k = k * k;

		PrintWriter out = res.getWriter();
		out.println("Result is " + k);

	}
}
