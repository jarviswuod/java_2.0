package _07_Cookies;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SquareServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		int k = 0;

		Cookie[] cookies = req.getCookies();

		for (Cookie c : cookies) {

			if (c.getName().equals("k"))
				k = Integer.parseInt(c.getValue());
		}

		k = k * k;

		PrintWriter out = res.getWriter();
		out.println("Result is " + k);

	}
}
